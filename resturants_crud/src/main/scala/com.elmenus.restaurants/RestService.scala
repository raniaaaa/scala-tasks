package com.elmenus.restaurants



import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.pattern.ask
import akka.util.Timeout
import com.elmenus.restaurants.messages.RestaurantsObject.Restaurants
import com.elmenus.restaurants.messages.{EventMarshaller, RestaurantsObject}

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}


class RestService(system: ActorSystem, timeout: Timeout) extends RestRoutes {
  implicit val requestTimeout: Timeout = timeout
  implicit def executionContext: ExecutionContextExecutor = system.dispatcher

  def GetRestaurant(): ActorRef = system.actorOf(RestaurantsObject.props)
}

trait RestRoutes extends RestaurantApi with EventMarshaller {
  val service = "api"
  val serviceName = "restaurant"


  protected val getAllRestaurants : Route = {
    pathPrefix(service / serviceName ) {
      get {
        pathEndOrSingleSlash {
          onSuccess(GetRestaurants()) { restaurant ⇒
            complete(OK, restaurant)
          }
        }
      }
    }
  }


  val routes: Route =  getAllRestaurants
}

trait RestaurantApi {

  def GetRestaurant(): ActorRef

  implicit def executionContext: ExecutionContext
  implicit def requestTimeout: Timeout

  lazy val restaurant: ActorRef = GetRestaurant()



  def GetRestaurants(): Future[Restaurants] = restaurant.ask(GetRestaurants).mapTo[Restaurants]


}

