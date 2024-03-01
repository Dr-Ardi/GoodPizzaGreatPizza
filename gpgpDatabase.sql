PGDMP  )                    |            GoodPizzaGP    16.1    16.0     	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16529    GoodPizzaGP    DATABASE        CREATE DATABASE "GoodPizzaGP" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Greek_Greece.1253';
    DROP DATABASE "GoodPizzaGP";
                postgres    false                       0    0    DATABASE "GoodPizzaGP"    ACL     o   REVOKE CONNECT,TEMPORARY ON DATABASE "GoodPizzaGP" FROM PUBLIC;
GRANT ALL ON DATABASE "GoodPizzaGP" TO PUBLIC;
                   postgres    false    4876            �            1259    16608    addables    TABLE     �   CREATE TABLE public.addables (
    item_type character varying(50),
    sizable boolean,
    meats boolean,
    cheeses boolean,
    sauces boolean,
    extras boolean,
    removables boolean
);
    DROP TABLE public.addables;
       public         heap    postgres    false            �            1259    16611    added    TABLE     �   CREATE TABLE public.added (
    add_type character varying(50),
    added_item character varying(50),
    added_price double precision
);
    DROP TABLE public.added;
       public         heap    postgres    false            �            1259    16535    ingredients    TABLE     d   CREATE TABLE public.ingredients (
    item_id integer,
    ingredient_name character varying(20)
);
    DROP TABLE public.ingredients;
       public         heap    postgres    false            �            1259    16584    item    TABLE     �   CREATE TABLE public.item (
    id bigint NOT NULL,
    name character varying(255),
    price double precision NOT NULL,
    priority integer NOT NULL,
    type character varying(255)
);
    DROP TABLE public.item;
       public         heap    postgres    false            �            1259    16591    item_seq    SEQUENCE     q   CREATE SEQUENCE public.item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.item_seq;
       public          postgres    false            �            1259    16621 	   order_seq    SEQUENCE     r   CREATE SEQUENCE public.order_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.order_seq;
       public          postgres    false            �            1259    16546    orders    TABLE     L  CREATE TABLE public.orders (
    table_number integer,
    priority integer,
    item_name character varying(40),
    extra character varying(255),
    excluded character varying(100),
    quantity integer,
    ordered boolean,
    order_cost double precision,
    included character varying(100),
    size character varying(50)
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16538    restaurant_tables    TABLE     �   CREATE TABLE public.restaurant_tables (
    table_number integer NOT NULL,
    occupied boolean,
    waiter_called boolean,
    payment character varying(20),
    finished boolean
);
 %   DROP TABLE public.restaurant_tables;
       public         heap    postgres    false            �            1259    16543    sizes    TABLE     �   CREATE TABLE public.sizes (
    item_type character varying(20) NOT NULL,
    item_size character varying(20) NOT NULL,
    added_cost double precision
);
    DROP TABLE public.sizes;
       public         heap    postgres    false                      0    16608    addables 
   TABLE DATA           b   COPY public.addables (item_type, sizable, meats, cheeses, sauces, extras, removables) FROM stdin;
    public          postgres    false    221   5                 0    16611    added 
   TABLE DATA           B   COPY public.added (add_type, added_item, added_price) FROM stdin;
    public          postgres    false    222   �       �          0    16535    ingredients 
   TABLE DATA           ?   COPY public.ingredients (item_id, ingredient_name) FROM stdin;
    public          postgres    false    215   �                 0    16584    item 
   TABLE DATA           ?   COPY public.item (id, name, price, priority, type) FROM stdin;
    public          postgres    false    219   5                 0    16546    orders 
   TABLE DATA           �   COPY public.orders (table_number, priority, item_name, extra, excluded, quantity, ordered, order_cost, included, size) FROM stdin;
    public          postgres    false    218   �        �          0    16538    restaurant_tables 
   TABLE DATA           e   COPY public.restaurant_tables (table_number, occupied, waiter_called, payment, finished) FROM stdin;
    public          postgres    false    216   !                  0    16543    sizes 
   TABLE DATA           A   COPY public.sizes (item_type, item_size, added_cost) FROM stdin;
    public          postgres    false    217   y!                  0    0    item_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.item_seq', 1, false);
          public          postgres    false    220                       0    0 	   order_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.order_seq', 1, true);
          public          postgres    false    223            n           2606    16590    item item_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    219            j           2606    16542     restaurant_tables restables_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.restaurant_tables
    ADD CONSTRAINT restables_pkey PRIMARY KEY (table_number);
 J   ALTER TABLE ONLY public.restaurant_tables DROP CONSTRAINT restables_pkey;
       public            postgres    false    216            l           2606    16615    sizes sizes_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.sizes
    ADD CONSTRAINT sizes_pkey PRIMARY KEY (item_type, item_size);
 :   ALTER TABLE ONLY public.sizes DROP CONSTRAINT sizes_pkey;
       public            postgres    false    217    217               i   x�s*-JO-�,�Lb0�
H,.I��˱� �$��"Ru+�L-���"�%P�`:�3�RQ���J\�2�Q�sS��,�rJE3* ��*�H�Cc���� �;2�         �   x�E��n�  �3|ž Z�������w����#����d'�m�����O�ޜmX�)!S]�~�Q4m�a �=N`ڭx\�|i�!���Y�3ȣ�X�_���|@9��>��@s_�v�,�8M�v��0��s���&��T���v���_o�����#�u8�3����"@�\��G���i�)M��C�b�g�E�:��:Ͽ���<�\7��Xk_ݪ��      �   ~  x�eRMw� <ï����^��^|�<��Iք�$����R5o3���,���N�U/iB���*f`(��Z��A4HSrD�H�ε�F�n4������)Y�b?!�u��P�񰏓.��"�,�qw�(�k5�V��<�r;CC����*l�T�k�e�zXh5D�פC���q8R��q�"|����3i7�F+��$d]1Ԩ�;X{��-�������Ϊ�A�PI�l�6���?��D�$%�q������s�S���#{�e�,d����=x�+�R�>�܌Of�n�gf�<��h�]=9y���"���,�!x��sD^\�����ا�]Ҝl��f3h��+�e�d��Dv�2������ͷ���
4�y���!�;�         �  x�u��n�0�����)N.��:�]�(P�u[�#e���y��Ǹ��	�H��Iڇ�Nd��b#�g��,�ڷ�� �oA׺~�H���$�s>[�.�+�Vf=L&ycH�_+���,���_��@*Qe(n�B�)d�{�N����%���6��x���"�
�	�VUW#��p_��h}ʿ0Rl�Jk���&a���^0�b�B�:��*������.��_�b�U��@b�6�j���dK�	]�w�.�<gL&$��	󂜓b��E+4�
�T\ ���P�īt�Hu�s�t��:����o5I��n�:͕��O��a&��T���?�܋[U�;��Z*j&��pcHe��1�,�8���I�;�yC�{@���5�Eӳ	Y��c���dd�O�xB>�//\�Uu@�&�Ê'fUrdo��Qlqo�E#��m������Pp�x�����xjD���Ӌ�{%rb��"�j�kO�t�9F�����9��2	[�*<�k�h��� ��3��,ek��忄��k"x�F�x`�$��a<\���u[���wh7Xly	,�$x��94Ǳ�A�S3��_�kc�N\�J//L<�z�M\�d^�~�S�n3��¬�?f����ďZf����)���=�<���B         =   x�3�4�t,(�IU�*�LN�t�()JTp.�,.�r�sJSR�jJ8�9=��?�=... ;�V      �   L   x�Mͻ� ј+���	W@L�/��h��M��j_�q��<�˼��|M����q��S�
Wa+|�߅�m1?/�          �   x�=���0D��W���'G�� E�HCc�Y�)�����&�{����m�i�x�vB�z�C�`��n�nm'%Y������&}FN�D	��T�6G�Su-�s��6i)Y�tE�O�&�ݙU�C�4L�c��7�B	�Х&
�-ʘj
���e�v�ӊ�/S�r<���(JN     