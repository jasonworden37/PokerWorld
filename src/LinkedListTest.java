import org.junit.Test;


public class LinkedListTest {
    @Test
      public void testAddingTwoPlayers() {
            LinkedList list = new LinkedList();
            Player jay = new Player("jason",15000);
            Player seth = new Player("seth",15000);
            list.add(jay);
            list.add(seth);
            assert(list.getSmall().player == seth);
            assert(list.getDealer().player == jay);
            assert(list.getBig().player == jay);
            assert(list.getTurn().player == seth);

        }
    @Test
    public void testAddingThreePlayers() {
        LinkedList list = new LinkedList();
        Player jay = new Player("jay",15000);
        Player seth = new Player("seth",15000);
        Player josh = new Player("josh",15000);
        list.add(jay);
        list.add(seth);
        list.add(josh);

        assert(list.getSmall().player.getName() == "seth");
        assert(list.getDealer().player.getName()  == "jay");
        assert(list.getBig().player.getName()  == "josh");
        assert(list.getTurn().player.getName()  == "jay");

    }

   /* @Test
    public void testAddingFourPlayers() {
        LinkedList list = new LinkedList();
        Player jay = new Player("jay",15000);
        Player seth = new Player("seth",15000);
        Player josh = new Player("josh",15000);
        list.add(jay);
        list.add(seth);
        list.add(josh);

        assert(list.getSmall().player.getName() == "seth");
        assert(list.getDealer().player.getName()  == "jay");
        assert(list.getBig().player.getName()  == "josh");
        assert(list.getTurn().player.getName()  == "jay");

    }*/
}


