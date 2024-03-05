PGDMP      7                |            GoodPizzaGP    16.1    16.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16529    GoodPizzaGP    DATABASE        CREATE DATABASE "GoodPizzaGP" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Greek_Greece.1253';
    DROP DATABASE "GoodPizzaGP";
                postgres    false                       0    0    DATABASE "GoodPizzaGP"    ACL     o   REVOKE CONNECT,TEMPORARY ON DATABASE "GoodPizzaGP" FROM PUBLIC;
GRANT ALL ON DATABASE "GoodPizzaGP" TO PUBLIC;
                   postgres    false    4878            �            1259    16608    addables    TABLE     �   CREATE TABLE public.addables (
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
    added_price double precision,
    id bigint
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
       public          postgres    false            �            1259    16546    orders    TABLE     d  CREATE TABLE public.orders (
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
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16538    restaurant_tables    TABLE     �   CREATE TABLE public.restaurant_tables (
    table_number integer NOT NULL,
    occupied boolean,
    waiter_called boolean,
    payment character varying(20),
    finished boolean
);
 %   DROP TABLE public.restaurant_tables;
       public         heap    postgres    false            �            1259    16624    sizes    TABLE     �   CREATE TABLE public.sizes (
    id bigint NOT NULL,
    item_type character varying(20),
    item_size character varying(20),
    added_cost double precision
);
    DROP TABLE public.sizes;
       public         heap    postgres    false                      0    16608    addables 
   TABLE DATA           b   COPY public.addables (item_type, sizable, meats, cheeses, sauces, extras, removables) FROM stdin;
    public          postgres    false    220   }                 0    16611    added 
   TABLE DATA           F   COPY public.added (add_type, added_item, added_price, id) FROM stdin;
    public          postgres    false    221   �                  0    16535    ingredients 
   TABLE DATA           ?   COPY public.ingredients (item_id, ingredient_name) FROM stdin;
    public          postgres    false    215                    0    16584    item 
   TABLE DATA           ?   COPY public.item (id, name, price, priority, type) FROM stdin;
    public          postgres    false    218   �                 0    16546    orders 
   TABLE DATA           �   COPY public.orders (table_number, priority, item_name, extra, excluded, quantity, ordered, order_cost, included, size, id) FROM stdin;
    public          postgres    false    217   A"                 0    16538    restaurant_tables 
   TABLE DATA           e   COPY public.restaurant_tables (table_number, occupied, waiter_called, payment, finished) FROM stdin;
    public          postgres    false    216   �"                 0    16624    sizes 
   TABLE DATA           E   COPY public.sizes (id, item_type, item_size, added_cost) FROM stdin;
    public          postgres    false    223   L#                  0    0    item_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.item_seq', 1, false);
          public          postgres    false    219                       0    0 	   order_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.order_seq', 11, true);
          public          postgres    false    222            n           2606    16590    item item_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    218            l           2606    16630    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    217            j           2606    16542     restaurant_tables restables_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.restaurant_tables
    ADD CONSTRAINT restables_pkey PRIMARY KEY (table_number);
 J   ALTER TABLE ONLY public.restaurant_tables DROP CONSTRAINT restables_pkey;
       public            postgres    false    216            p           2606    16628    sizes sizes_pkey1 
   CONSTRAINT     O   ALTER TABLE ONLY public.sizes
    ADD CONSTRAINT sizes_pkey1 PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.sizes DROP CONSTRAINT sizes_pkey1;
       public            postgres    false    223               i   x�s*-JO-�,�Lb0�
H,.I��˱� �$��"Ru+�L-���"�%P�`:�3�RQ���J\�2�Q�sS��,�rJE3* ��*�H�Cc���� �;2�           x�E�Kr�0�|��������F50��1f���+�iW�'��-S���'��R����8��͂=�_4xXi�3X�/M�8�Iڮ`�Ld�3Ъab^�r�r��S�9�}���$y�#�#��ć�F�a/�Y�~S�e�� �Zi�����(Z�ONô��.x��?�۾6�'���4��坣y�[�?),�R^-�L�R����]>�
�c
a�	����0E��z̬�0?rZ��ǝ��T�.���/�n�Q��R�b�{          ~  x�eRMw� <ï����^��^|�<��Iք�$����R5o3���,���N�U/iB���*f`(��Z��A4HSrD�H�ε�F�n4������)Y�b?!�u��P�񰏓.��"�,�qw�(�k5�V��<�r;CC����*l�T�k�e�zXh5D�פC���q8R��q�"|����3i7�F+��$d]1Ԩ�;X{��-�������Ϊ�A�PI�l�6���?��D�$%�q������s�S���#{�e�,d����=x�+�R�>�܌Of�n�gf�<��h�]=9y���"���,�!x��sD^\�����ا�]Ҝl��f3h��+�e�d��Dv�2������ͷ���
4�y���!�;�         �  x�u��n�0�����)N.��:�]�(P�u[�#e���y��Ǹ��	�H��Iڇ�Nd��b#�g��,�ڷ�� �oA׺~�H���$�s>[�.�+�Vf=L&ycH�_+���,���_��@*Qe(n�B�)d�{�N����%���6��x���"�
�	�VUW#��p_��h}ʿ0Rl�Jk���&a���^0�b�B�:��*������.��_�b�U��@b�6�j���dK�	]�w�.�<gL&$��	󂜓b��E+4�
�T\ ���P�īt�Hu�s�t��:����o5I��n�:͕��O��a&��T���?�܋[U�;��Z*j&��pcHe��1�,�8���I�;�yC�{@���5�Eӳ	Y��c���dd�O�xB>�//\�Uu@�&�Ê'fUrdo��Qlqo�E#��m������Pp�x�����xjD���Ӌ�{%rb��"�j�kO�t�9F�����9��2	[�*<�k�h��� ��3��,ek��忄��k"x�F�x`�$��a<\���u[���wh7Xly	,�$x��94Ǳ�A�S3��_�kc�N\�J//L<�z�M\�d^�~�S�n3��¬�?f����ďZf����)���=�<���B         �   x�m��� ���S�h��C��8�ԟ�)H��H�O/Cc4���s�/G���Q��&BG�s�3��p|��4��k8��b���`��O��e���j�놋7?�i�3W�@s�0����/4�^e�*������1�m�et)��f=g�� YeBI         R   x�Uλ�@�����L$H�D�/6�ȉ_6���~�wi18F���cul���
�B�:��DHZ*[�~��J]D��@T         �   x�=���0D�ݯ�$�����R$�"��Ic%�)Lh����P�{��!x�m3��4��L��pY��ǭsQJ91�2�����0�J2�
�5@~�|��M"?Q��V�� ���.�5��Bg����c�3�Ak$��Z�MfY�&JY�T �D"� �$�H�PH
�����\�ͤ�86�]����=!O     