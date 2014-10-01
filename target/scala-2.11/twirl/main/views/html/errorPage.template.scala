
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
object errorPage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Throwable,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(t: Throwable):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
404 Page not found <br>
"""),_display_(/*11.2*/t),format.raw/*11.3*/(""" """),format.raw/*11.4*/("""<br> <br>
<a href = "/problems"> Back to problem list </a>
</body>
</html>"""))}
  }

  def render(t:Throwable): play.twirl.api.HtmlFormat.Appendable = apply(t)

  def f:((Throwable) => play.twirl.api.HtmlFormat.Appendable) = (t) => apply(t)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Sep 28 16:11:39 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/errorPage.scala.html
                  HASH: c6a176e3084bc4fdd444505bf8c10e953938ea32
                  MATRIX: 730->1|832->15|860->17|1018->149|1039->150|1067->151
                  LINES: 26->1|29->1|31->3|39->11|39->11|39->11
                  -- GENERATED --
              */
          