--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.0

-- Started on 2024-07-02 14:59:14

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
-- TOC entry 220 (class 1259 OID 16608)
-- Name: addables; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.addables (
    item_type character varying(50),
    sizable boolean,
    meats boolean,
    cheeses boolean,
    sauces boolean,
    extras boolean,
    removables boolean
);


ALTER TABLE public.addables OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16611)
-- Name: added; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.added (
    add_type character varying(50),
    added_item character varying(50),
    added_price double precision,
    id bigint
);


ALTER TABLE public.added OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16535)
-- Name: ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingredients (
    item_id integer,
    ingredient_name character varying(20),
    id integer NOT NULL
);


ALTER TABLE public.ingredients OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16631)
-- Name: ingredients_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingredients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ingredients_id_seq OWNER TO postgres;

--
-- TOC entry 4883 (class 0 OID 0)
-- Dependencies: 224
-- Name: ingredients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingredients_id_seq OWNED BY public.ingredients.id;


--
-- TOC entry 218 (class 1259 OID 16584)
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
-- TOC entry 219 (class 1259 OID 16591)
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
-- TOC entry 222 (class 1259 OID 16621)
-- Name: order_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_seq OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16546)
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
    order_cost double precision,
    included character varying(100),
    size character varying(50),
    id bigint NOT NULL
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
-- TOC entry 223 (class 1259 OID 16624)
-- Name: sizes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sizes (
    id bigint NOT NULL,
    item_type character varying(20),
    item_size character varying(20),
    added_cost double precision
);


ALTER TABLE public.sizes OWNER TO postgres;

--
-- TOC entry 4714 (class 2604 OID 16639)
-- Name: ingredients id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredients ALTER COLUMN id SET DEFAULT nextval('public.ingredients_id_seq'::regclass);


--
-- TOC entry 4873 (class 0 OID 16608)
-- Dependencies: 220
-- Data for Name: addables; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.addables (item_type, sizable, meats, cheeses, sauces, extras, removables) FROM stdin;
Burger	t	f	t	t	t	t
Pasta	f	f	f	f	f	f
Appetiser	f	f	f	t	f	f
Fries	t	f	f	t	f	f
Water	t	f	f	f	f	f
Wine	t	f	f	f	f	f
Soft Drink	t	f	f	f	f	f
Salad	f	f	f	f	f	t
Beer	t	f	f	f	f	f
Pizza	t	t	t	t	t	t
Burger	t	f	t	t	t	t
Pasta	f	f	f	f	f	f
Appetiser	f	f	f	t	f	f
Fries	t	f	f	t	f	f
Water	t	f	f	f	f	f
Wine	t	f	f	f	f	f
Soft Drink	t	f	f	f	f	f
Salad	f	f	f	f	f	t
Beer	t	f	f	f	f	f
Pizza	t	t	t	t	t	t
\.


--
-- TOC entry 4874 (class 0 OID 16611)
-- Dependencies: 221
-- Data for Name: added; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.added (add_type, added_item, added_price, id) FROM stdin;
meat	turkey	0.6	1
meat	pepperoni	0.8	2
meat	bacon	1.2	3
meat	mortadhela	1	4
meat	pariza	0.9	5
meat	ham	0.75	6
cheese	american	0.5	7
cheese	feta	0.65	8
cheese	cheddar	0.8	9
cheese	gouda	0.6	10
cheese	mozzarella	0.55	11
sauce	mustard	0.3	12
sauce	ketchup	0.4	13
sauce	BBQ sauce	0.8	14
sauce	hot sauce	0.7	15
sauce	mayonnaise	0.65	16
extra	lettuce	0.5	17
extra	tomato	85	18
extra	corn	0.75	19
extra	pineapple	0.8	20
extra	mushrooms	0.6	21
extra	egg	1.1	22
extra	peppers	0.4	23
extra	hot peppers	0.75	24
meat	turkey	0.6	1
meat	pepperoni	0.8	2
meat	bacon	1.2	3
meat	mortadhela	1	4
meat	pariza	0.9	5
meat	ham	0.75	6
cheese	american	0.5	7
cheese	feta	0.65	8
cheese	cheddar	0.8	9
cheese	gouda	0.6	10
cheese	mozzarella	0.55	11
sauce	mustard	0.3	12
sauce	ketchup	0.4	13
sauce	BBQ sauce	0.8	14
sauce	hot sauce	0.7	15
sauce	mayonnaise	0.65	16
extra	lettuce	0.5	17
extra	tomato	85	18
extra	corn	0.75	19
extra	pineapple	0.8	20
extra	mushrooms	0.6	21
extra	egg	1.1	22
extra	peppers	0.4	23
extra	hot peppers	0.75	24
\.


--
-- TOC entry 4868 (class 0 OID 16535)
-- Dependencies: 215
-- Data for Name: ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingredients (item_id, ingredient_name, id) FROM stdin;
1	pepperoni	1
1	tomato sauce	2
1	gouda cheese	3
2	feta cheese	4
2	tomato sauce	5
2	gouda cheese	6
2	cream cheese	7
3	tomato sauce	8
3	mozzarella	9
3	chicken	10
3	chicken nuggets	11
4	tomato sauce	12
4	mozzarella	13
4	bazil	14
5	gouda cheese	15
5	tomato sauce	16
5	chicken	17
5	bbg sauce	18
6	feta cheese	19
6	tomato sauce	20
6	mozzarella	21
6	tomatoes	22
7	philadelfia	23
7	mozzarella	24
7	bazil	25
7	tomato sauce	26
8	chicken nuggets	27
8	tomato sauce	28
8	gouda cheese	29
9	meatballs	30
9	tomato sauce	31
9	mozzarella	32
10	pepperoni	33
10	tomato sauce	34
10	mozzarella	35
10	mushrooms	36
11	Hambuger Patty	37
11	Cabbage	38
11	Tomato	39
11	Mayonnaise	40
12	Mayonnaise	41
13	Mayonnaise	42
13	BBQ Sauce	43
14	BBQ Sauce	44
15	BBQ Sauce	45
12	Gouda Cheese	46
12	Hambuger Patty	47
12	Cabbage	48
12	Tomato	49
13	Hambuger Patty	50
13	Cabbage	51
13	Tomato	52
13	Gouda Cheese	53
13	Bacon	54
13	Fried Egg	55
14	Hambuger Patty	56
14	Cabbage	57
14	Tomato	58
14	Gouda Cheese	59
14	Double Bacon	60
14	Onion	61
15	Tomato	62
15	Hambuger Patty	63
15	Cabbage	64
15	Mozzarella	65
15	Caramellized Onions	66
15	Onion Ring	67
16	Chicken Burger	68
16	BBQ Sauce	69
16	Hot Sauce	70
16	Ghost Peppers	71
16	Cabbage	72
16	Cheddar	73
27	Tomatoes	74
27	Cucumbers	75
27	Red onions	76
27	Feta cheese	77
27	Olives	78
28	Lettuce	79
28	Croutons	80
28	Parmesan cheese	81
28	Caesar dressing	82
29	Barley rusk	83
29	Tomatoes	84
29	Feta cheese	85
29	Olives	86
29	Capers	87
17	Cheese cream	88
17	Bacon	89
17	Pariza	90
18	Tomato sauce	91
18	Minced meat	92
20	Multiple Cheeces	93
19	Pesto	94
21	Parmesan cheese	95
21	Squid Ink	96
21	Tomatoes	97
21	Parmesan cheese	98
\.


--
-- TOC entry 4871 (class 0 OID 16584)
-- Dependencies: 218
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
18	Bolognese Penne	7	4	Pasta
\.


--
-- TOC entry 4870 (class 0 OID 16546)
-- Dependencies: 217
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (table_number, priority, item_name, extra, excluded, quantity, ordered, order_cost, included, size, id) FROM stdin;
1	1	Amstel Free			2	t	10.6		500ml	41
1	2	Cretan Salad		Tomatoes, 	1	t	5.7			39
1	3	French Fries			1	t	2.7	ketchup, 	Medium (70gr)	38
1	4	Classic Pizza		mozzarella, 	2	t	23	pepperoni, bacon, 0.8, 	Medium (33cm)	37
1	4	Cheese Burger		Tomato, 	1	t	10.45	0.5, 0.65, ketchup, lettuce, 	Large (180gr)	40
\.


--
-- TOC entry 4869 (class 0 OID 16538)
-- Dependencies: 216
-- Data for Name: restaurant_tables; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.restaurant_tables (table_number, occupied, waiter_called, payment, finished) FROM stdin;
5	f	f	Cash	f
7	f	f	Cash	f
8	f	f	Cash	f
9	f	f	Cash	f
10	f	f	Cash	f
11	f	f	Cash	f
12	f	f	Cash	f
13	f	f	Cash	f
14	f	f	Cash	f
16	f	f	Cash	f
17	f	f	Cash	f
18	f	f	Cash	f
19	f	f	Cash	f
20	f	f	Cash	f
1	f	f	Cash	t
2	f	f	Cash	f
15	f	t	Cash	f
4	f	f	Cash	f
6	f	f	Cash	t
3	f	f	Cash	f
\.


--
-- TOC entry 4876 (class 0 OID 16624)
-- Dependencies: 223
-- Data for Name: sizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sizes (id, item_type, item_size, added_cost) FROM stdin;
1	Pizza	Small (25.4cm)	0
2	Pizza	Medium (33cm)	1.2
3	Pizza	Large (38.1cm)	3.3
4	Burger	Medium (90gr)	0
5	Burger	Large (180gr)	2.4
6	Beer	330ml	0
7	Beer	500ml	1.3
8	Water	500ml	0
9	Water	1L	1.5
10	Wine	Glass	0
11	Wine	250ml	1.2
12	Wine	500ml	3.3
13	Wine	1L	4
14	Fries	Medium (70gr)	0
15	Fries	Large (140gr)	1.6
\.


--
-- TOC entry 4884 (class 0 OID 0)
-- Dependencies: 224
-- Name: ingredients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingredients_id_seq', 98, true);


--
-- TOC entry 4885 (class 0 OID 0)
-- Dependencies: 219
-- Name: item_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_seq', 1, false);


--
-- TOC entry 4886 (class 0 OID 0)
-- Dependencies: 222
-- Name: order_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_seq', 41, true);


--
-- TOC entry 4716 (class 2606 OID 16634)
-- Name: ingredients ingredients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredients
    ADD CONSTRAINT ingredients_pkey PRIMARY KEY (id);


--
-- TOC entry 4722 (class 2606 OID 16590)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- TOC entry 4720 (class 2606 OID 16630)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 4718 (class 2606 OID 16542)
-- Name: restaurant_tables restables_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurant_tables
    ADD CONSTRAINT restables_pkey PRIMARY KEY (table_number);


--
-- TOC entry 4724 (class 2606 OID 16628)
-- Name: sizes sizes_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sizes
    ADD CONSTRAINT sizes_pkey1 PRIMARY KEY (id);


-- Completed on 2024-07-02 14:59:14

--
-- PostgreSQL database dump complete
--

