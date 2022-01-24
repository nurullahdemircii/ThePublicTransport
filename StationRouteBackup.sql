--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.2

-- Started on 2022-01-24 04:50:24

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
-- TOC entry 201 (class 1259 OID 18350)
-- Name: routes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.routes (
    id integer NOT NULL,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.routes OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 18348)
-- Name: routes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.routes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.routes_id_seq OWNER TO postgres;

--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 200
-- Name: routes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.routes_id_seq OWNED BY public.routes.id;


--
-- TOC entry 203 (class 1259 OID 18361)
-- Name: routes_stations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.routes_stations (
    id integer NOT NULL,
    sequence_number integer,
    routes_id integer,
    stations_id integer
);


ALTER TABLE public.routes_stations OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 18359)
-- Name: routes_stations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.routes_stations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.routes_stations_id_seq OWNER TO postgres;

--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 202
-- Name: routes_stations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.routes_stations_id_seq OWNED BY public.routes_stations.id;


--
-- TOC entry 205 (class 1259 OID 18369)
-- Name: stations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stations (
    id integer NOT NULL,
    location character varying(255),
    name character varying(255)
);


ALTER TABLE public.stations OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 18367)
-- Name: stations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stations_id_seq OWNER TO postgres;

--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 204
-- Name: stations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.stations_id_seq OWNED BY public.stations.id;


--
-- TOC entry 207 (class 1259 OID 18380)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    password_repeat character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 18378)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 206
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 209 (class 1259 OID 18391)
-- Name: vehicles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vehicles (
    id integer NOT NULL,
    name character varying(255),
    plate character varying(255),
    route_id integer
);


ALTER TABLE public.vehicles OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 18389)
-- Name: vehicles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vehicles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vehicles_id_seq OWNER TO postgres;

--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 208
-- Name: vehicles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vehicles_id_seq OWNED BY public.vehicles.id;


--
-- TOC entry 2878 (class 2604 OID 18353)
-- Name: routes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes ALTER COLUMN id SET DEFAULT nextval('public.routes_id_seq'::regclass);


--
-- TOC entry 2879 (class 2604 OID 18364)
-- Name: routes_stations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes_stations ALTER COLUMN id SET DEFAULT nextval('public.routes_stations_id_seq'::regclass);


--
-- TOC entry 2880 (class 2604 OID 18372)
-- Name: stations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stations ALTER COLUMN id SET DEFAULT nextval('public.stations_id_seq'::regclass);


--
-- TOC entry 2881 (class 2604 OID 18383)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2882 (class 2604 OID 18394)
-- Name: vehicles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicles ALTER COLUMN id SET DEFAULT nextval('public.vehicles_id_seq'::regclass);


--
-- TOC entry 3027 (class 0 OID 18350)
-- Dependencies: 201
-- Data for Name: routes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.routes (id, description, name) FROM stdin;
1	Trabzon Akçaabat Güzergahı	Rota-1
2	Akçaabat Trabzon Güzergahı	Rota-2
\.


--
-- TOC entry 3029 (class 0 OID 18361)
-- Dependencies: 203
-- Data for Name: routes_stations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.routes_stations (id, sequence_number, routes_id, stations_id) FROM stdin;
1	1	1	1
2	1	1	3
3	1	1	5
4	1	2	5
5	1	2	3
6	1	2	2
7	1	2	1
\.


--
-- TOC entry 3031 (class 0 OID 18369)
-- Dependencies: 205
-- Data for Name: stations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stations (id, location, name) FROM stdin;
1	Trabzon	A
2	Trabzon	B
3	Trabzon	C
4	Trabzon	D
5	Trabzon	E
\.


--
-- TOC entry 3033 (class 0 OID 18380)
-- Dependencies: 207
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, first_name, last_name, password, password_repeat) FROM stdin;
1	nurullahdemirci061@gmail.com	Nurullah	Demirci	123456	123456
\.


--
-- TOC entry 3035 (class 0 OID 18391)
-- Dependencies: 209
-- Data for Name: vehicles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vehicles (id, name, plate, route_id) FROM stdin;
2	Mercedes	61 TR 000061	1
3	Ford	61 TR 006100	2
\.


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 200
-- Name: routes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.routes_id_seq', 2, true);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 202
-- Name: routes_stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.routes_stations_id_seq', 7, true);


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 204
-- Name: stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.stations_id_seq', 5, true);


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 206
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 208
-- Name: vehicles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vehicles_id_seq', 3, true);


--
-- TOC entry 2884 (class 2606 OID 18358)
-- Name: routes routes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY (id);


--
-- TOC entry 2886 (class 2606 OID 18366)
-- Name: routes_stations routes_stations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes_stations
    ADD CONSTRAINT routes_stations_pkey PRIMARY KEY (id);


--
-- TOC entry 2888 (class 2606 OID 18377)
-- Name: stations stations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stations
    ADD CONSTRAINT stations_pkey PRIMARY KEY (id);


--
-- TOC entry 2890 (class 2606 OID 18388)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2892 (class 2606 OID 18399)
-- Name: vehicles vehicles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicles
    ADD CONSTRAINT vehicles_pkey PRIMARY KEY (id);


--
-- TOC entry 2893 (class 2606 OID 18400)
-- Name: routes_stations fk6mmehfb8hgtg24qtvoc9q91y8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes_stations
    ADD CONSTRAINT fk6mmehfb8hgtg24qtvoc9q91y8 FOREIGN KEY (routes_id) REFERENCES public.routes(id);


--
-- TOC entry 2895 (class 2606 OID 18410)
-- Name: vehicles fkoixubksvdr6r5cf76ub5tktrt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicles
    ADD CONSTRAINT fkoixubksvdr6r5cf76ub5tktrt FOREIGN KEY (route_id) REFERENCES public.routes(id);


--
-- TOC entry 2894 (class 2606 OID 18405)
-- Name: routes_stations fkr7ty9d3p1av9455ym72ldvlqq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes_stations
    ADD CONSTRAINT fkr7ty9d3p1av9455ym72ldvlqq FOREIGN KEY (stations_id) REFERENCES public.stations(id);


-- Completed on 2022-01-24 04:50:24

--
-- PostgreSQL database dump complete
--

