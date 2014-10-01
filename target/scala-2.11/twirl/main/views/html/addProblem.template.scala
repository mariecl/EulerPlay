
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
object addProblem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(text: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import models.Problems

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*4.1*/("""

"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<h2>"""),_display_(/*14.6*/text),format.raw/*14.10*/("""</h2>
<form name="addProblem" action=/new method="post">
    <fieldset>
        <legend>Problem information:</legend>
        Problem name:<br> <em>(ex: Problem 4)</em>
        <dd><input type="text" name="problemName" required value="Problem 4"></dd>
        Problem question:<br> <em>(ex: How much is 2 plus 1?)</em>
        <dd><input type="text" name="problemQuestion" required value="How much is 2 plus 1?"></dd>
    </fieldset>
    <fieldset>
        <legend>Parameter 1:</legend>
        <dt><label>Parameter name:<br> <em>(computer readable)</em></label></dt>
        <dd><input type="text" name="parameterName_1" required value=Test></dd>
        <dt><label>Proper parameter name:<br> <em>(human readable)</em></label></dt>
        <dd><input type="text" name="parameterProperName_1" required value=Test></dd>
        <dt><label>Default value:<br> <em>(ex: 4)</em></label></dt>
        <dd><input type="number" name="parameterDefaultValue_1" required value=4></dd>
    </fieldset>
    <dd><input type="submit" value="Submit"></dd>
</form>
</p>
</body>
</html>"""))}
  }

  def render(text:String): play.twirl.api.HtmlFormat.Appendable = apply(text)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (text) => apply(text)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Sep 29 16:12:44 EDT 2014
                  SOURCE: /Development/EulerPlay/app/views/addProblem.scala.html
                  HASH: f60e5df53c815ef9c11c3e52f6eaed797f5ef441
                  MATRIX: 728->1|852->15|880->41|908->43|1042->151|1067->155
                  LINES: 26->1|29->1|31->4|33->6|41->14|41->14
                  -- GENERATED --
              */
          