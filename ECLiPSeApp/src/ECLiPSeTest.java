/**
 * Christos Gogos
 * TEI of Epirus 2016
 * 
 */
import java.io.File;
import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseEngine;
import com.parctechnologies.eclipse.EclipseEngineOptions;
import com.parctechnologies.eclipse.EmbeddedEclipse;

public class ECLiPSeTest {

	public static void main(String[] args) throws Exception {
		// initialization of the ECLiPSe environment
		EclipseEngineOptions eclipseEngineOptions = new EclipseEngineOptions();
		EclipseEngine eclipse = EmbeddedEclipse.getInstance(eclipseEngineOptions);

		// Load prolog program
		File mapColouringProgram = new File("simple_clp.ecl");
		eclipse.compile(mapColouringProgram);

		// get a single result from a query
		CompoundTerm result2 = eclipse.rpc("solve_clp(X,Y,Z)");
		System.out.printf("X=%d Y=%d Z=%d\n", result2.arg(1), result2.arg(2), result2.arg(3));

		// get all results
		CompoundTerm result1 = eclipse.rpc("findall([X,Y,Z], solve_clp(X,Y,Z), L)");
		System.out.println("Results=" + result1.arg(3));

		// free resources held by the ECLiPSe environment
		((EmbeddedEclipse) eclipse).destroy();
	}

}