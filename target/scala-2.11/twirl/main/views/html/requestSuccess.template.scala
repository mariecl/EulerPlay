
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object requestSuccess extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(text: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <p>"""),_display_(/*10.9*/text),format.raw/*10.13*/("""</p>
    <p>What do you want to do next?</p>
    <button onclick="location.href='problems'"> Back to problem list</button>
    <button onclick="location.href='new'"> Add a new problem</button>
</body>
</html>"""))}
  }

  def render(text:String): play.twirl.api.HtmlFormat.Appendable = apply(text)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (text) => apply(text)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 29 18:53:39 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/requestSuccess.scala.html
                  HASH: b5d4d91f19cc6a88a5727ce85246222357b88db2
                  MATRIX: 732->1|834->15|862->17|998->127|1023->131
                  LINES: 26->1|29->1|31->3|38->10|38->10
                  -- GENERATED --
              */
          