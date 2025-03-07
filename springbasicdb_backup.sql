--
-- PostgreSQL database dump
--

-- Dumped from database version 15.11 (Homebrew)
-- Dumped by pg_dump version 15.11 (Homebrew)

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
-- Name: message; Type: TABLE; Schema: public; Owner: springuser
--

CREATE TABLE public.message (
    id bigint NOT NULL,
    content character varying(255)
);


ALTER TABLE public.message OWNER TO springuser;

--
-- Name: message_id_seq; Type: SEQUENCE; Schema: public; Owner: springuser
--

ALTER TABLE public.message ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: todo; Type: TABLE; Schema: public; Owner: springuser
--

CREATE TABLE public.todo (
    id bigint NOT NULL,
    assignee character varying(255),
    assigner character varying(255),
    description character varying(255),
    status character varying(255),
    target_date date,
    title character varying(255)
);


ALTER TABLE public.todo OWNER TO springuser;

--
-- Name: todo_id_seq; Type: SEQUENCE; Schema: public; Owner: springuser
--

ALTER TABLE public.todo ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.todo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: springuser
--

COPY public.message (id, content) FROM stdin;
1	ahlb bkom fe masr
2	ahlb bkom fe masr
\.


--
-- Data for Name: todo; Type: TABLE DATA; Schema: public; Owner: springuser
--

COPY public.todo (id, assignee, assigner, description, status, target_date, title) FROM stdin;
1	Ahmed	Mohamed	Complete Spring Boot REST API Tutorial	IN_PROGRESS	2025-03-01	Learn Spring Boot
2	모함메드	서진석 책임	Practice Spring boot functions and build	in-progress	2025-02-21	Friday Task
3	Soha	Sayed	practice spring boot tools and functions	IN_PROGRESS	2025-02-28	first mission for the spring boot
4	모함메드	서진석 책임	Practice Spring boot functions and build	in-progress	2025-02-22	Monday Task
5	Ahmed	Mohamed	Complete Spring Boot REST API Tutorial	IN_PROGRESS	2025-03-01	Learn Spring Boot
6	Ahmed	Mohamed	Complete Spring Boot REST API Tutorial	IN_PROGRESS	2025-03-01	Learn Spring Boot
7	ali	mohamed	hello	PENDING	2025-02-28	front test
8	모함메드	서진석 책임	did it by myself	COMPLETED	2025-02-19	first spring mission
9	Ahmed	Mohamed	Complete Spring Boot REST API Tutorial	IN_PROGRESS	2025-03-01	Learn Spring Boot
\.


--
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: springuser
--

SELECT pg_catalog.setval('public.message_id_seq', 2, true);


--
-- Name: todo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: springuser
--

SELECT pg_catalog.setval('public.todo_id_seq', 9, true);


--
-- Name: message message_pkey; Type: CONSTRAINT; Schema: public; Owner: springuser
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id);


--
-- Name: todo todo_pkey; Type: CONSTRAINT; Schema: public; Owner: springuser
--

ALTER TABLE ONLY public.todo
    ADD CONSTRAINT todo_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

