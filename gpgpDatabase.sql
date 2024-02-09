--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.0

-- Started on 2024-02-10 00:27:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16535)
-- Name: ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingredients (
    item_id integer,
    ingredient_name character varying(20)
);


ALTER TABLE public.ingredients OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16584)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    id bigint NOT NULL,
    name character varying(255),
    price double precision NOT NULL,
    priority integer NOT NULL,
    type character varying(255)
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16591)
-- Name: item_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.item_seq OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16546)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    table_number integer,
    priority integer,
    item_name character varying(40),
    extra character varying(255),
    excluded character varying(100),
    quantity integer,
    ordered boolean,
    order_cost double precision
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16538)
-- Name: restaurant_tables; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.restaurant_tables (
    table_number integer NOT NULL,
    occupied boolean,
    waiter_called boolean,
    payment character varying(20),
    finished boolean
);


ALTER TABLE public.restaurant_tables OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16543)
-- Name: sizes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sizes (
    item_type character varying(20),
    item_size character varying(20),
    added_cost double precision
);


ALTER TABLE public.sizes OWNER TO postgres;

--
-- TOC entry 4851 (class 0 OID 16535)
-- Dependencies: 215
-- Data for Name: ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingredients (item_id, ingredient_name) FROM stdin;
1	pepperoni
1	tomato sauce
1	gouda cheese
2	feta cheese
2	tomato sauce
2	gouda cheese
2	cream cheese
3	tomato sauce
3	mozzarella
3	chicken
3	chicken nuggets
4	tomato sauce
4	mozzarella
4	bazil
5	gouda cheese
5	tomato sauce
5	chicken
5	bbg sauce
6	feta cheese
6	tomato sauce
6	mozzarella
6	tomatoes
7	philadelfia
7	mozzarella
7	bazil
7	tomato sauce
8	chicken nuggets
8	tomato sauce
8	gouda cheese
9	meatballs
9	tomato sauce
9	mozzarella
10	pepperoni
10	tomato sauce
10	mozzarella
10	mushrooms
11	Hambuger Patty
11	Cabbage
11	Tomato
11	Mayonnaise
12	Mayonnaise
13	Mayonnaise
13	BBQ Sauce
14	BBQ Sauce
15	BBQ Sauce
12	Gouda Cheese
12	Hambuger Patty
12	Cabbage
12	Tomato
13	Hambuger Patty
13	Cabbage
13	Tomato
13	Gouda Cheese
13	Bacon
13	Fried Egg
14	Hambuger Patty
14	Cabbage
14	Tomato
14	Gouda Cheese
14	Double Bacon
14	Onion
15	Tomato
15	Hambuger Patty
15	Cabbage
15	Mozzarella
15	Caramellized Onions
15	Onion Ring
16	Chicken Burger
16	BBQ Sauce
16	Hot Sauce
16	Ghost Peppers
16	Cabbage
16	Cheddar
\.


--
-- TOC entry 4855 (class 0 OID 16584)
-- Dependencies: 219
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item (id, name, price, priority, type) FROM stdin;
1	Pepperoni Pizza	8.5	4	Pizza
2	Cheesy Pizza	8	4	Pizza
3	Double Chcken Pizza	10.6	4	Pizza
4	Classic Pizza	7.5	4	Pizza
5	BBQ Chicken Pizza	11.2	4	Pizza
6	Greek Pizza	8.5	4	Pizza
7	Bianca Fina Philadelphia	12	4	Pizza
8	Crosscut Nuggets Pizza	8.5	4	Pizza
9	Meatball Pizza	9	4	Pizza
10	Mushroom Pizza	7	4	Pizza
11	Basic Burger	5	4	Burger
12	Cheese Burger	6	4	Burger
13	American Breakfast	8.5	4	Burger
14	Max Bacon	7.5	4	Burger
15	Drunken Onion	7.2	4	Burger
16	Hell time	8.7	4	Burger
17	Spaghetti Carbonara	8.2	4	Pasta
18	Penne with Bolognese Sauce	7	4	Pasta
19	Spaghetti with Pesto	7.3	4	Pasta
20	Mac n Cheese	9	4	Pasta
21	Squid Ink Linguine	10.4	4	Pasta
22	French Fries	2.3	3	Fries
27	Greek Salad	5.6	2	Salad
28	Ceasar Salad	6	2	Salad
29	Cretan Salad	5.7	2	Salad
31	Water	1	1	Water
38	Alfa	3	1	Beer
39	Amstel	3.7	1	Beer
40	Amstel Radrel	4	1	Beer
41	Amstel Free	4	1	Beer
42	Nymfh	3.5	1	Beer
43	Red Wine	2.7	1	Wine
46	Sweet Red Wine	3	1	Wine
44	Rose Wine	3	1	Wine
45	White Wine	2.7	1	Wine
47	Georgiadi Retsina	3	1	Wine
48	Malamatina Retsina	2.7	1	Wine
23	Tzatziki	2.7	3	Appetiser
24	Tirokafteri	3	3	Appetiser
25	Cheese Sticks	4.5	3	Appetiser
26	Onion Rings	5.2	3	Appetiser
30	Bread	2	1	Appetiser
32	Coca Cola	3	1	Soft Drink
33	Coca Cola Zero	3.5	1	Soft Drink
34	Coca Cola Light	3.7	1	Soft Drink
35	Ice Tea Peach	2.5	1	Soft Drink
36	Orange Juice	3	1	Soft Drink
37	Apple Juice	3	1	Soft Drink
\.


--
-- TOC entry 4854 (class 0 OID 16546)
-- Dependencies: 218
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (table_number, priority, item_name, extra, excluded, quantity, ordered, order_cost) FROM stdin;
\.


--
-- TOC entry 4852 (class 0 OID 16538)
-- Dependencies: 216
-- Data for Name: restaurant_tables; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.restaurant_tables (table_number, occupied, waiter_called, payment, finished) FROM stdin;
1	f	f	\N	f
2	f	f	\N	f
3	f	f	\N	f
4	f	f	\N	f
5	f	f	\N	f
6	f	f	\N	f
7	f	f	\N	f
8	f	f	\N	f
9	f	f	\N	f
10	f	f	\N	f
11	f	f	\N	f
12	f	f	\N	f
13	f	f	\N	f
14	f	f	\N	f
15	f	f	\N	f
16	f	f	\N	f
17	f	f	\N	f
18	f	f	\N	f
19	f	f	\N	f
20	f	f	\N	f
\.


--
-- TOC entry 4853 (class 0 OID 16543)
-- Dependencies: 217
-- Data for Name: sizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sizes (item_type, item_size, added_cost) FROM stdin;
Pizza	Small (25.4cm)	0
Pizza	Medium (33cm)	1.2
Pizza	Large (38.1cm)	3.3
Burger	Medium (90gr)	0
Burger	Large (180gr)	2.4
Beer	330ml	0
Beer	500ml	1.3
Water	500ml	0
Water	1L	1.5
Wine	Glass	0
Wine	250ml	1.2
Wine	500ml	3.3
Wine	1L	4
Fries	Medium (70gr)	0
Fries	Large (140gr)	1.6
\.


--
-- TOC entry 4862 (class 0 OID 0)
-- Dependencies: 220
-- Name: item_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_seq', 1, false);


--
-- TOC entry 4707 (class 2606 OID 16590)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- TOC entry 4705 (class 2606 OID 16542)
-- Name: restaurant_tables restables_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurant_tables
    ADD CONSTRAINT restables_pkey PRIMARY KEY (table_number);


-- Completed on 2024-02-10 00:27:38

--
-- PostgreSQL database dump complete
--

