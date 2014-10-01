
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
object answer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Long,List[models.Parameters],Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(question: String, answer: Long, parameters: List[models.Parameters], id: Int):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.80*/("""

        """),format.raw/*3.9*/("""<body>"""),_display_(/*3.16*/question),format.raw/*3.24*/(""" """),format.raw/*3.25*/("""<br><br><br>
        The answer is """),_display_(/*4.24*/answer),format.raw/*4.30*/(""".<br><br><br><br>
        You can change the parameters of the question if you want: <br><br>

        <form name="changeParameters" action=""""),_display_(/*7.48*/id),format.raw/*7.50*/("""" method="get">
            """),_display_(/*8.14*/for(parameter <- parameters) yield /*8.42*/ {_display_(Seq[Any](format.raw/*8.44*/("""
            """),format.raw/*9.13*/("""<dt><label>"""),_display_(/*9.25*/parameter/*9.34*/.getProperName()),format.raw/*9.50*/(""":<br> <em>(ex: default is """),_display_(/*9.77*/parameter/*9.86*/.getParameterDefaultValue),format.raw/*9.111*/("""</em></label></dt>
            <dd><input type="number" name=""""),_display_(/*10.45*/parameter/*10.54*/.getParameterName()),format.raw/*10.73*/("""" required value=""""),_display_(/*10.92*/parameter/*10.101*/.getParameterDefaultValue()),format.raw/*10.128*/(""""></dd>
            """)))}),format.raw/*11.14*/("""
            """),format.raw/*12.13*/("""<dd><input type="submit" value="Submit"></dd>
        </form>

        <button onclick="location.href='problems'"> Back to problem list</button>

        </body>"""))}
  }

  def render(question:String,answer:Long,parameters:List[models.Parameters],id:Int): play.twirl.api.HtmlFormat.Appendable = apply(question,answer,parameters,id)

  def f:((String,Long,List[models.Parameters],Int) => play.twirl.api.HtmlFormat.Appendable) = (question,answer,parameters,id) => apply(question,answer,parameters,id)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 29 16:39:15 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/answer.scala.html
                  HASH: feb5c8bb4cd41794ba9bf1909e50b8f508d0adfa
                  MATRIX: 757->1|923->79|959->89|992->96|1020->104|1048->105|1110->141|1136->147|1304->289|1326->291|1381->320|1424->348|1463->350|1503->363|1541->375|1558->384|1594->400|1647->427|1664->436|1710->461|1800->524|1818->533|1858->552|1904->571|1923->580|1972->607|2024->628|2065->641
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|39->11|40->12
                  -- GENERATED --
              */
          