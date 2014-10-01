// @SOURCE:/Development/EulerPlay/conf/routes
// @HASH:825faa8765fcd919ebb86fa8acf623bbd9ed0ed3
// @DATE:Mon Sep 29 16:47:38 EDT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseProblems {


// @LINE:9
def show(id:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "problems/" + implicitly[PathBindable[Int]].unbind("id", id))
}
                        

// @LINE:17
def delete(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "delete")
}
                        

// @LINE:12
def addNew(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "new")
}
                        

// @LINE:13
def submit(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "new")
}
                        

// @LINE:16
def showListDelete(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "delete")
}
                        

// @LINE:6
def showList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "problems")
}
                        

}
                          
}
                  


// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseProblems {


// @LINE:9
def show : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problems.show",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "problems/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:17
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problems.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
      }
   """
)
                        

// @LINE:12
def addNew : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problems.addNew",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "new"})
      }
   """
)
                        

// @LINE:13
def submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problems.submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "new"})
      }
   """
)
                        

// @LINE:16
def showListDelete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problems.showListDelete",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
      }
   """
)
                        

// @LINE:6
def showList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problems.showList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "problems"})
      }
   """
)
                        

}
              
}
        


// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseProblems {


// @LINE:9
def show(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problems.show(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "show", Seq(classOf[Int]), "GET", """ Problem 1""", _prefix + """problems/$id<[^/]+>""")
)
                      

// @LINE:17
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problems.delete(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "delete", Seq(), "POST", """""", _prefix + """delete""")
)
                      

// @LINE:12
def addNew(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problems.addNew(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "addNew", Seq(), "GET", """ Add a new problem""", _prefix + """new""")
)
                      

// @LINE:13
def submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problems.submit(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "submit", Seq(), "POST", """""", _prefix + """new""")
)
                      

// @LINE:16
def showListDelete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problems.showListDelete(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "showListDelete", Seq(), "GET", """ Delete a problem""", _prefix + """delete""")
)
                      

// @LINE:6
def showList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problems.showList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problems", "showList", Seq(), "GET", """ Problem list""", _prefix + """problems""")
)
                      

}
                          
}
        
    