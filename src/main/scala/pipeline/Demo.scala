package pipeline

import com.databricks.ml.local.LocalModel
import com.databricks.ml.local.ModelFactory

object Demo extends App{

	val path = "src/main/resources/logreg"
  val model = ModelFactory.loadModel(path)
  println(s"MODEL: $model")

        
  val outputs = Array("label", "prediction")
  model.setOutputCols(outputs)

        
  val input = """
  {
    "label":1.0,
    "features":
      {
     	  "type":0,
      	"size":13,
      	"indices":[0,1,2,3,4,6,7,9,10,11,12],
      	"values":[70.0,1.0,4.0,130.0,322.0,2.0,109.0,2.4,2.0,3.0,3.0]
      }
  }"""

  println(s"INPUT: $input")

  val output = model.transform(input)
  println(s"OUTPUT: $output")

}
