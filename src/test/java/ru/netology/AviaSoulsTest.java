package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Нижневартовск", "Омск", 55_000, 8,14);
    Ticket ticket2 = new Ticket("Екатеринбург", "Сочи", 27_000, 3, 7);
    Ticket ticket3 = new Ticket("Казань", "Мурманск", 37_000, 15,20);
    Ticket ticket4 = new Ticket("Нижневартовск", "Омск", 30_000, 6,9);
    Ticket ticket5 = new Ticket("Сочи", "Екатеринбург", 45_500, 6,12);
    Ticket ticket6 = new Ticket("Нижневартовск", "Омск", 13_500, 10,15);
    Ticket ticket7 = new Ticket("Казань", "Мурманск", 35_000, 4,6);
    Ticket ticket8 = new Ticket("Воронеж", "Владикавказ", 26_000, 14,18);
    Ticket ticket9 = new Ticket("Казань", "Мурманск", 20_000, 15,16);
    Ticket ticket10 = new Ticket("Нижневартовск", "Омск", 18_000, 11,15);

    @Test
    public void showThatPriceAreGreater() {
        manager.add(ticket1);
        manager.add(ticket2);

        int expected = 28_000;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void showThatPriceAreLess() {
        manager.add(ticket1);
        manager.add(ticket2);

        int expected = -28_000;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void showThatPricesAreEqual() {
        manager.add(ticket3);
        manager.add(ticket4);

        int expected = 7000;
        int actual = ticket3.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromNVTToOMSK() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket6, ticket10, ticket4, ticket1};
        Ticket[] actual = manager.search("Нижневартовск", "Омск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromKAZToMUR() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9, ticket7, ticket3};
        Ticket[] actual = manager.search("Казань", "Мурманск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromVORToVLAD() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.search("Воронеж", "Владикавказ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromCHITAToMSK() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Чита", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareThatOneDepartureTimeAreLessThanAnother() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        int expected = 1;
        int actual = comparator.compare(ticket5, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareThatOneDepartureTimeAreGreaterThanAnother() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        int expected = -1;
        int actual = comparator.compare(ticket3, ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareThatOneDepartureTimeAreEqualThanAnother() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        int expected = 3;
        int actual = comparator.compare(ticket8, ticket9);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromNVTToOMSKByDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket4, ticket10, ticket6, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Нижневартовск", "Омск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromKAZToMURDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9, ticket7, ticket3};
        Ticket[] actual = manager.searchAndSortBy("Казань", "Мурманск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromVORToVLDDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.searchAndSortBy("Воронеж", "Владикавказ", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTheTicketsFromCHITAToMSKDepartureTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Чита", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
