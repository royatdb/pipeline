
package pipeline

import org.openjdk.jmh.annotations.{Benchmark, State, Scope}
import com.databricks.ml.local.LocalModel
import com.databricks.ml.local.ModelFactory

object DemoBenchmark {

  @State(Scope.Benchmark)
	class DemoModel{
		val path = "src/main/resources/logreg"
		val model = ModelFactory.loadModel(path)
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

		def transform():Unit = {
			val output = model.transform(input)
			assert(output == "{\"prediction\":1.0,\"label\":1.0}")
		}

	}

}

class DemoBenchmark {

	import DemoBenchmark._
	
	@Benchmark
  	def transform(demo: DemoModel): Unit = {
    	demo.transform()
  	}
}