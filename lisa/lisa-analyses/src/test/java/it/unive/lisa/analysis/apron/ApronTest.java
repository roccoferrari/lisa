package it.unive.lisa.analysis.apron;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ApronTest {

    @Test
    public void testApronBoxInitialization() {
        try {
            // test for Box domain
            Apron.setManager(Apron.ApronDomain.Box);

            Apron state = new Apron().top();
            assertTrue(state.isTop(), "Created state is TOP");
            System.out.println("Success: JApron loaded and Box created");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace(System.err);
            fail("Error: JApron crashed");
        }
    }

    @Test
    public void testApronPolkaInitialization() {
        try {
            Apron.setManager(Apron.ApronDomain.Polka);

            Apron state = new Apron().bottom();
            assertTrue(state.isBottom(), "Created state is BOTTOM");
            System.out.println("Success: JApron loaded and Polka created");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace(System.err);
            fail("Error: JApron crashed");
        }
    }
}