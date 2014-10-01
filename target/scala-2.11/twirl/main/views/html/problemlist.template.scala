
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
object problemlist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[models.Problems],HashMap[models.Problems, String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(problems : List[models.Problems], queryStrings : HashMap[models.Problems, String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.85*/("""

"""),format.raw/*3.1*/("""<head lang="en">
    <meta charset="UTF-8">
    <title>Problem List</title>
</head>

<body>
<h1>List of available problems:</h1>

<ul>
    """),_display_(/*12.6*/for(problem <- problems) yield /*12.30*/ {_display_(Seq[Any](format.raw/*12.32*/("""

    """),format.raw/*14.5*/("""<li> <a href = "/problems/"""),_display_(/*14.32*/problem/*14.39*/.getProblemId()),_display_(/*14.55*/queryStrings/*14.67*/.get(problem)),format.raw/*14.80*/(""""> """),_display_(/*14.84*/problem/*14.91*/.getProblemName()),format.raw/*14.108*/(""" """),format.raw/*14.109*/("""</a></li>
    """)))}),format.raw/*15.6*/("""
"""),format.raw/*16.1*/("""</ul>

<button onclick="location.href='new'"> Add a new problem</button>
<button onclick="location.href='delete'"> Delete an existing problem</button>

</body>"""))}
  }

  def render(problems:List[models.Problems],queryStrings:HashMap[models.Problems, String]): play.twirl.api.HtmlFormat.Appendable = apply(problems,queryStrings)

  def f:((List[models.Problems],HashMap[models.Problems, String]) => play.twirl.api.HtmlFormat.Appendable) = (problems,queryStrings) => apply(problems,queryStrings)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 29 16:47:38 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/problemlist.scala.html
                  HASH: 8f0da995a65e2161a3366cd31d2fc6433e1bd782
                  MATRIX: 777->1|948->84|976->86|1142->226|1182->250|1222->252|1255->258|1309->285|1325->292|1361->308|1382->320|1416->333|1447->337|1463->344|1502->361|1532->362|1577->377|1605->378
                  LINES: 26->1|29->1|31->3|40->12|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|43->15|44->16
                  -- GENERATED --
              */
          