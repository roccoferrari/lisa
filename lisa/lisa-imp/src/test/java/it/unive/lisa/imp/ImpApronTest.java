package it.unive.lisa.imp;

import static org.junit.jupiter.api.Assertions.fail;
import it.unive.lisa.analysis.apron.Apron;
import it.unive.lisa.outputs.JSONInputs;
import it.unive.lisa.program.Program;
import it.unive.lisa.util.testing.AnalysisTestExecutor;
import it.unive.lisa.util.testing.TestConfiguration;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class ImpApronTest extends AnalysisTestExecutor {

    public ImpApronTest() {
        // folder in: src/test/resources
        super("src/test/resources/apron-testcases", AnalysisTestExecutor.DEFAULT_ACTUAL_DIR);
    }

    @Test
    public void testApronManagerOnly() {
        // Load of the lib
        try {
            Apron.setManager(Apron.ApronDomain.Box);
        } catch (Throwable e) {
            e.printStackTrace();
            fail("Error in JApron loading: " + e.getMessage());
        }

        TestConfiguration conf = new TestConfiguration();
        conf.testDir = "box";
        conf.programFile = "apron_test.imp";
        conf.outputs.add(new JSONInputs());

        // FIXME: conf.analysis

        perform(conf);
    }

    @Override
    public Program readProgram(TestConfiguration conf, Path target) {
        Program program = null;
        try {
            // Frontend IMP
            program = IMPFrontend.processFile(target.toString(), false);
        } catch (ParsingException e) {
            e.printStackTrace(System.err);
            fail("Error during parsing of '" + target + "': " + e.getMessage());
        }
        return program;
    }
}