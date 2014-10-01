
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
object notFoundPage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
Page not found <br>
"""),_display_(/*11.2*/request),format.raw/*11.9*/(""" """),format.raw/*11.10*/("""<br> <br>

<a href = "/problems"> Back to problems list </a>
</body>
</html>"""))}
  }

  def render(request:String): play.twirl.api.HtmlFormat.Appendable = apply(request)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (request) => apply(request)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Sep 30 16:34:49 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/notFoundPage.scala.html
                  HASH: c7741a2e9dd9bd89f14d93e1a1abff3cabf7a4b6
                  MATRIX: 730->1|835->18|863->20|1012->143|1039->150|1068->151
                  LINES: 26->1|29->1|31->3|39->11|39->11|39->11
                  -- GENERATED --
              */
          