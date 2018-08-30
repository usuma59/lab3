import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    public void shouldCreateoxObjectCorrectly() {
        OX ox = new OX();

        assertEquals(" 012\n0---\n1---\n2---\n",ox.getTableString());
        assertEquals(0, ox.getCountX());
        assertEquals(0, ox.getCountO());
        assertEquals(0, ox.getCountDraw());

    }
    @Test
    public void put() {

        OX ox = new OX();
        ox.put(1,1);
        assertEquals(" 012\n0---\n1-X-\n2---\n",ox.getTableString());

        ox.put(0,0);
        assertEquals(" 012\n0X--\n1-X-\n2---\n",ox.getTableString());

        ox.put(2,1);
        assertEquals(" 012\n0X--\n1-XX\n2---\n",ox.getTableString());

        ox.switchPlayer(); //O
        ox.put(0,2);
        assertEquals(" 012\n0X--\n1-XX\n2O--\n",ox.getTableString());

        assertEquals(false, ox.put(0,2));

        assertEquals(false,ox.put(0,3));

    }
    @Test
    public void switchPlayer() {
        OX ox = new OX () ;
        ox.switchPlayer();
        assertEquals("O",ox.getCurrentPlayer());
        ox.switchPlayer ();
        assertEquals("X",ox.getCurrentPlayer());

    }
    @Test
    public void checkWin1() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals(" 012\n0X--\n1X--\n2X--\n",ox.getTableString());
        assertEquals( true,ox.checkWin(0,0));
        assertEquals( true,ox.checkWin(0,1));
        assertEquals( true,ox.checkWin(0,2));
    }
    @Test
    public void checkWin2() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);

        assertEquals(" 012\n0X--\n1X--\n2---\n",ox.getTableString());
        assertEquals( false,ox.checkWin(0,0));
        assertEquals( false,ox.checkWin(0,1));

    }
    @Test
    public void checkWin3() {
        OX ox = new OX();
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertEquals(" 012\n0-X-\n1-X-\n2-X-\n",ox.getTableString());
        assertEquals( true,ox.checkWin(1,0));
        assertEquals( true,ox.checkWin(1,1));
        assertEquals( true,ox.checkWin(1,2));
    }
    @Test
    public void checkWin4() {
        OX ox = new OX();
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertEquals(" 012\n0--X\n1--X\n2--X\n",ox.getTableString());
        assertEquals( true,ox.checkWin(2,0));
        assertEquals( true,ox.checkWin(2,1));
        assertEquals( true,ox.checkWin(2,2));
    }
}