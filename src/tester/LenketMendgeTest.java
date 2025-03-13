package tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mengder.LenketMengde;
import mengder.MengdeADT;

class LenketMendgeTest {

	private LenketMengde<Integer> mengde;
	
	@BeforeEach
	public void testemengde() {
		mengde = new LenketMengde<>();
	}
	
	@Test
	public void testErTom() {
		assertTrue(mengde.erTom());
        mengde.leggTil(1);
        assertFalse(mengde.erTom());
    }

    @Test
    public void testInneholder() {
        mengde.leggTil(1);
        assertTrue(mengde.inneholder(1));
        assertFalse(mengde.inneholder(2));
    }

    @Test
    public void testLeggTil() {
        mengde.leggTil(1);
        assertEquals(1, mengde.antallElementer());
        mengde.leggTil(2);
        assertEquals(2, mengde.antallElementer());
        mengde.leggTil(1); 
        assertEquals(2, mengde.antallElementer());
    }

    @Test
    public void testFjern() {
        mengde.leggTil(1);
        mengde.leggTil(2);
        assertEquals(2, mengde.antallElementer());
        assertEquals(1, mengde.fjern(1));
        assertEquals(1, mengde.antallElementer());
        assertNull(mengde.fjern(3)); 
    }

    @Test
    public void testTilTabell() {
        mengde.leggTil(1);
        mengde.leggTil(2);
        Integer[] tabell = mengde.tilTabell();
        assertEquals(2, tabell.length);
        assertTrue(tabell[0] == 1 || tabell[0] == 2);
        assertTrue(tabell[1] == 1 || tabell[1] == 2);
    }

    @Test
    public void testErDelmengdeAv() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        assertTrue(mengde.erDelmengdeAv(annenMengde));
        annenMengde.fjern(1);
        assertFalse(mengde.erDelmengdeAv(annenMengde));
    }

    @Test
    public void testErLik() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);
        assertTrue(mengde.erLik(annenMengde));
        annenMengde.leggTil(3);
        assertFalse(mengde.erLik(annenMengde));
    }

    @Test
    public void testErDisjunkt() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        annenMengde.leggTil(3);
        assertTrue(mengde.erDisjunkt(annenMengde));
        annenMengde.leggTil(2);
        assertFalse(mengde.erDisjunkt(annenMengde));
    }

    @Test
    public void testSnitt() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        MengdeADT<Integer> snittMengde = mengde.snitt(annenMengde);
        assertTrue(snittMengde.inneholder(2));
        assertFalse(snittMengde.inneholder(1));
        assertFalse(snittMengde.inneholder(3));
    }

    @Test
    public void testUnion() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        MengdeADT<Integer> unionMengde = mengde.union(annenMengde);
        assertTrue(unionMengde.inneholder(1));
        assertTrue(unionMengde.inneholder(2));
        assertTrue(unionMengde.inneholder(3));
    }

    @Test
    public void testMinus() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        MengdeADT<Integer> minusMengde = mengde.minus(annenMengde);
        assertTrue(minusMengde.inneholder(1));
        assertFalse(minusMengde.inneholder(2));
        assertFalse(minusMengde.inneholder(3));
	}
    
    @Test
    public void testAntallElementer() {
		assertEquals(0, mengde.antallElementer());
		mengde.leggTil(1);
		assertEquals(1, mengde.antallElementer());
    }

}
