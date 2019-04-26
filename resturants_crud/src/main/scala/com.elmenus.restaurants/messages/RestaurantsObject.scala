package com.elmenus.restaurants.messages

import akka.actor.Props
import com.elmenus.restaurants.actors.RestaurantsActors

object RestaurantsObject {

  def props() = Props(new RestaurantsActors())


  case class GetRestaurants()
  case class getOpenedRestaurants()
  case class editRestaurantData(updatedRestaurant : Restaurant)

  case class AddRestaurant (restaurant: Vector[Restaurant])
  case class Restaurant(uuid: Int , data:Data)
  case class Data(enName:String, arName:String, state :String, routingMethod :String, logo:String, coverPhoto:String, enDescription :String, arDescription :String, shortNumber :String, facebookLink:String, twitterLink :String, youtubeLink :String, website :String, onlinePayment :String, client:String, pendingInfo :String, pendingMenu :String, closed:Boolean )
  case class Restaurants(entries: Vector[Restaurant] = Vector.empty[Restaurant])
}
