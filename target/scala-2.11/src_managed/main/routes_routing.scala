// @SOURCE:/Development/EulerPlay/conf/routes
// @HASH:825faa8765fcd919ebb86fa8acf623bbd9ed0ed3
// @DATE:Mon Sep 29 16:47:38 EDT 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Problems_showList0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("problems"))))
private[this] lazy val controllers_Problems_showList0_invoker = createInvoker(
controllers.Problems.showList(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "showList", Nil,"GET", """ Problem list""", Routes.prefix + """problems"""))
        

// @LINE:9
private[this] lazy val controllers_Problems_show1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("problems/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Problems_show1_invoker = createInvoker(
controllers.Problems.show(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "show", Seq(classOf[Int]),"GET", """ Problem 1""", Routes.prefix + """problems/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_Problems_addNew2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("new"))))
private[this] lazy val controllers_Problems_addNew2_invoker = createInvoker(
controllers.Problems.addNew(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "addNew", Nil,"GET", """ Add a new problem""", Routes.prefix + """new"""))
        

// @LINE:13
private[this] lazy val controllers_Problems_submit3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("new"))))
private[this] lazy val controllers_Problems_submit3_invoker = createInvoker(
controllers.Problems.submit(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "submit", Nil,"POST", """""", Routes.prefix + """new"""))
        

// @LINE:16
private[this] lazy val controllers_Problems_showListDelete4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete"))))
private[this] lazy val controllers_Problems_showListDelete4_invoker = createInvoker(
controllers.Problems.showListDelete(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "showListDelete", Nil,"GET", """ Delete a problem""", Routes.prefix + """delete"""))
        

// @LINE:17
private[this] lazy val controllers_Problems_delete5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete"))))
private[this] lazy val controllers_Problems_delete5_invoker = createInvoker(
controllers.Problems.delete(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "delete", Nil,"POST", """""", Routes.prefix + """delete"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problems""","""controllers.Problems.showList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problems/$id<[^/]+>""","""controllers.Problems.show(id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """new""","""controllers.Problems.addNew()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """new""","""controllers.Problems.submit()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete""","""controllers.Problems.showListDelete()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete""","""controllers.Problems.delete()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Problems_showList0_route(params) => {
   call { 
        controllers_Problems_showList0_invoker.call(controllers.Problems.showList())
   }
}
        

// @LINE:9
case controllers_Problems_show1_route(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_Problems_show1_invoker.call(controllers.Problems.show(id))
   }
}
        

// @LINE:12
case controllers_Problems_addNew2_route(params) => {
   call { 
        controllers_Problems_addNew2_invoker.call(controllers.Problems.addNew())
   }
}
        

// @LINE:13
case controllers_Problems_submit3_route(params) => {
   call { 
        controllers_Problems_submit3_invoker.call(controllers.Problems.submit())
   }
}
        

// @LINE:16
case controllers_Problems_showListDelete4_route(params) => {
   call { 
        controllers_Problems_showListDelete4_invoker.call(controllers.Problems.showListDelete())
   }
}
        

// @LINE:17
case controllers_Problems_delete5_route(params) => {
   call { 
        controllers_Problems_delete5_invoker.call(controllers.Problems.delete())
   }
}
        
}

}
     