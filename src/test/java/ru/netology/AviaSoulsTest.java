package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 3500, 9, 14);
    Ticket ticket2 = new Ticket("Владивосток", "Санкт-Петербург", 25_000, 9, 18);
    Ticket ticket3 = new Ticket("Москва", "Санкт-Петербург", 4500, 9, 10);
    Ticket ticket4 = new Ticket("Санкт-Петербург", "Уфа", 7000, 14, 17);
    Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 2500, 16, 18);
    Ticket ticket6 = new Ticket("Москва", "Санкт-Петербург", 7000, 15, 19);
    Ticket ticket7 = new Ticket("Красноярск", "Санкт-Петербург", 12_000, 14, 19);
    Ticket ticket8 = new Ticket("Краснодар", "Санкт-Петербург", 27_000, 14, 18);
    Ticket ticket9 = new Ticket("Москва", "Санкт-Петербург", 1500, 7, 10);
    Ticket ticket10 = new Ticket("Ярославль", "Санкт-Петербург", 9000, 16, 18);

    AviaSouls aviaSouls = new AviaSouls();

    @Test
    public void shouldSortFewTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);

        Ticket[] actual = aviaSouls.search("Москва", "Санкт-Петербург");
        Ticket[] expected = {ticket9, ticket5, ticket1, ticket3, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);

        Ticket[] actual = aviaSouls.search("Краснодар", "Санкт-Петербург");
        Ticket[] expected = {ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNullTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);

        Ticket[] actual = aviaSouls.search("Пермь", "Санкт-Петербург");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsByTime() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Санкт-Петербург", comparator);
        Ticket[] expected = {ticket3, ticket5, ticket9, ticket6, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicketsByTime() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.searchAndSortBy("Краснодар", "Санкт-Петербург", comparator);
        Ticket[] expected = {ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNullTicketsByTime() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.searchAndSortBy("Пермь", "Санкт-Петербург", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}