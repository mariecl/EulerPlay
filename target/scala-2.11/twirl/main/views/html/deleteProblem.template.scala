
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
object deleteProblem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[models.Problems],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(problems : List[models.Problems]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*3.1*/("""<head lang="en">
    <meta charset="UTF-8">
    <title>Delete</title>
</head>

<body>
<h1>List of problems available for deletion:</h1>

<form name="deleteProblem" action="/delete" method="post">
<ul>
    """),_display_(/*13.6*/for(problem <- problems) yield /*13.30*/ {_display_(Seq[Any](format.raw/*13.32*/("""
    """),format.raw/*14.5*/("""<li>
        <dt><label>"""),_display_(/*15.21*/problem/*15.28*/.getProblemName()),format.raw/*15.45*/("""</label></dt>
        <dd><input type="checkbox" name=""""),_display_(/*16.43*/problem/*16.50*/.getProblemId()),format.raw/*16.65*/(""""></dd>
    </li>
    """)))}),format.raw/*18.6*/("""
"""),format.raw/*19.1*/("""</ul>
    <dd><input type="submit" value="Submit"></dd>
</form>

</body>"""))}
  }

  def render(problems:List[models.Problems]): play.twirl.api.HtmlFormat.Appendable = apply(problems)

  def f:((List[models.Problems]) => play.twirl.api.HtmlFormat.Appendable) = (problems) => apply(problems)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 29 16:49:25 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/deleteProblem.scala.html
                  HASH: 78d454a9eff6f9644f097019aaed4e147ba25dad
                  MATRIX: 746->1|868->35|896->37|1128->243|1168->267|1208->269|1240->274|1292->299|1308->306|1346->323|1429->379|1445->386|1481->401|1534->424|1562->425
                  LINES: 26->1|29->1|31->3|41->13|41->13|41->13|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|47->19
                  -- GENERATED --
              */
          