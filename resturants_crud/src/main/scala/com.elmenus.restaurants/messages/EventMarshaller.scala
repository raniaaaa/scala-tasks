package com.elmenus.restaurants.messages

import play.api.libs.json._
import de.heikoseeberger.akkahttpplayjson._



// message containing an error
case class Error(message: String)

// convert our case classes from and to JSON
trait EventMarshaller extends PlayJsonSupport {

  implicit val dataFormat: OFormat[RestaurantsObject.Data] = Json.format[RestaurantsObject.Data]

  implicit val restaurantFormat: OFormat[RestaurantsObject.Restaurant] = Json.format[RestaurantsObject.Restaurant]
  implicit val restaurantsFormat: OFormat[RestaurantsObject.Restaurants] = Json.format[RestaurantsObject.Restaurants]
}

object EventMarshaller extends EventMarshaller
