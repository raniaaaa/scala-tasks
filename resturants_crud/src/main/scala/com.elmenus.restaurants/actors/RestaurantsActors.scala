package com.elmenus.restaurants.actors

import akka.actor.Actor
import com.elmenus.restaurants.messages.RestaurantsObject._

class RestaurantsActors  () extends Actor {

   var restaurants = Vector.empty[Restaurant]

  def receive: PartialFunction[Any, Unit] = {
    case AddRestaurant(newRestaurant) ⇒ restaurants = restaurants ++ newRestaurant

    case GetRestaurants() ⇒

      sender() ! Restaurants(restaurants)
    case editRestaurantData(updatedRestaurant) ⇒restaurants = restaurants
     case class getOpenedRestaurants()



  }
}
