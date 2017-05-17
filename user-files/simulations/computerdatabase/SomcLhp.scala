package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SomcLhp extends Simulation {

  val httpConf = http
    .baseURL("https://www.sonymobile.com") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/gb")
      .check(
		  status.is(200))
		  )
  .pause(1)
  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
 }