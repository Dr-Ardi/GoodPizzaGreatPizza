PGDMP  	                    |           GoodPizzaGP    16.1    16.0 +               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16529    GoodPizzaGP    DATABASE        CREATE DATABASE "GoodPizzaGP" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Greek_Greece.1253';
    DROP DATABASE "GoodPizzaGP";
                postgres    false                        0    0    DATABASE "GoodPizzaGP"    ACL     o   REVOKE CONNECT,TEMPORARY ON DATABASE "GoodPizzaGP" FROM PUBLIC;
GRANT ALL ON DATABASE "GoodPizzaGP" TO PUBLIC;
                   postgres    false    4895            �            1259    24864    addables    TABLE     �   CREATE TABLE public.addables (
    id bigint NOT NULL,
    item_type character varying(50),
    sizable boolean,
    meats boolean,
    cheeses boolean,
    sauces boolean,
    extras boolean,
    removables boolean
);
    DROP TABLE public.addables;
       public         heap    postgres    false            �            1259    24859    addables_seq    SEQUENCE     u   CREATE SEQUENCE public.addables_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.addables_seq;
       public          postgres    false            �            1259    16611    added    TABLE     �   CREATE TABLE public.added (
    add_type character varying(50),
    added_item character varying(50),
    added_price double precision,
    id bigint
);
    DROP TABLE public.added;
       public         heap    postgres    false            �            1259    24860 	   added_seq    SEQUENCE     r   CREATE SEQUENCE public.added_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.added_seq;
       public          postgres    false            �            1259    24861 
   ingred_seq    SEQUENCE     s   CREATE SEQUENCE public.ingred_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.ingred_seq;
       public          postgres    false            �            1259    16535    ingredients    TABLE     |   CREATE TABLE public.ingredients (
    item_id integer,
    ingredient_name character varying(20),
    id bigint NOT NULL
);
    DROP TABLE public.ingredients;
       public         heap    postgres    false            �            1259    16631    ingredients_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ingredients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.ingredients_id_seq;
       public          postgres    false    215            !           0    0    ingredients_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.ingredients_id_seq OWNED BY public.ingredients.id;
          public          postgres    false    223            �            1259    16584    item    TABLE     �   CREATE TABLE public.item (
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
       public         heap    postgres    false            �            1259    24862    rest_seq    SEQUENCE     q   CREATE SEQUENCE public.rest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.rest_seq;
       public          postgres    false            �            1259    16538    restaurant_tables    TABLE     �   CREATE TABLE public.restaurant_tables (
    table_number bigint NOT NULL,
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
       public         heap    postgres    false            �            1259    24863 	   sizes_seq    SEQUENCE     r   CREATE SEQUENCE public.sizes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.sizes_seq;
       public          postgres    false            o           2604    24846    ingredients id    DEFAULT     p   ALTER TABLE ONLY public.ingredients ALTER COLUMN id SET DEFAULT nextval('public.ingredients_id_seq'::regclass);
 =   ALTER TABLE public.ingredients ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    215                      0    24864    addables 
   TABLE DATA           f   COPY public.addables (id, item_type, sizable, meats, cheeses, sauces, extras, removables) FROM stdin;
    public          postgres    false    229   �,                 0    16611    added 
   TABLE DATA           F   COPY public.added (add_type, added_item, added_price, id) FROM stdin;
    public          postgres    false    220   V-                 0    16535    ingredients 
   TABLE DATA           C   COPY public.ingredients (item_id, ingredient_name, id) FROM stdin;
    public          postgres    false    215   x.                 0    16584    item 
   TABLE DATA           ?   COPY public.item (id, name, price, priority, type) FROM stdin;
    public          postgres    false    218   L1                 0    16546    orders 
   TABLE DATA           �   COPY public.orders (table_number, priority, item_name, extra, excluded, quantity, ordered, order_cost, included, size, id) FROM stdin;
    public          postgres    false    217   �3                 0    16538    restaurant_tables 
   TABLE DATA           e   COPY public.restaurant_tables (table_number, occupied, waiter_called, payment, finished) FROM stdin;
    public          postgres    false    216    4                 0    16624    sizes 
   TABLE DATA           E   COPY public.sizes (id, item_type, item_size, added_cost) FROM stdin;
    public          postgres    false    222   c4       "           0    0    addables_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.addables_seq', 1, false);
          public          postgres    false    224            #           0    0 	   added_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.added_seq', 1, false);
          public          postgres    false    225            $           0    0 
   ingred_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.ingred_seq', 1, false);
          public          postgres    false    226            %           0    0    ingredients_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.ingredients_id_seq', 98, true);
          public          postgres    false    223            &           0    0    item_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.item_seq', 1, false);
          public          postgres    false    219            '           0    0 	   order_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.order_seq', 71, true);
          public          postgres    false    221            (           0    0    rest_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.rest_seq', 1, false);
          public          postgres    false    227            )           0    0 	   sizes_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.sizes_seq', 1, false);
          public          postgres    false    228            {           2606    24868    addables addables_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.addables
    ADD CONSTRAINT addables_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.addables DROP CONSTRAINT addables_pkey;
       public            postgres    false    229            q           2606    24848    ingredients ingredients_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.ingredients
    ADD CONSTRAINT ingredients_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.ingredients DROP CONSTRAINT ingredients_pkey;
       public            postgres    false    215            w           2606    16590    item item_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    218            u           2606    16630    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    217            s           2606    24854     restaurant_tables restables_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.restaurant_tables
    ADD CONSTRAINT restables_pkey PRIMARY KEY (table_number);
 J   ALTER TABLE ONLY public.restaurant_tables DROP CONSTRAINT restables_pkey;
       public            postgres    false    216            y           2606    16628    sizes sizes_pkey1 
   CONSTRAINT     O   ALTER TABLE ONLY public.sizes
    ADD CONSTRAINT sizes_pkey1 PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.sizes DROP CONSTRAINT sizes_pkey1;
       public            postgres    false    222               �   x�3�t*-JO-�,�Lb0�2�H,.I��!�1�cAAjIf1P-D�,n��V��Z�A�L9�K�f���q�g楢Yp'�$� YS�e�锊��Ѐ3 ��*�<��9���J\�2�Q����� �5f           x�E�Kr�0�|��������F50��1f���+�iW�'��-S���'��R����8��͂=�_4xXi�3X�/M�8�Iڮ`�Ld�3Ъab^�r�r��S�9�}���$y�#�#��ć�F�a/�Y�~S�e�� �Zi�����(Z�ONô��.x��?�۾6�'���4��坣y�[�?),�R^-�L�R����]>�
�c
a�	����0E��z̬�0?rZ��ǝ��T�.���/�n�Q��R�b�{         �  x�m��n�0��ç�"%n׸MR�Fܤ�^(���hq����3��No�?��sH����~�8�0����dts�A ��y�����!c^�t�9�(C"�2�r� Ͳ8� h����iX��.�|<�I7W��F���q.��J�u�Nu<g26�%�8]!���(������s� R�d�]�k�A��x����k���ux��lVH��k+f>@h�q�A�RXf��n*\ӌ��(���S����:]݅,#���92�y<}�b�8�G�s�d��2Mp��UXÐ��BfIl�{�u���2."�W2�� pw�3y	�r���5z�k-��C�f���Ѝ�\�����en��M�L	^�e����`1j)��ڕ}2�������[U������ർ&u)oH��-���\4>9wQ)����oN3Yҕ q�Ne/�T���㜕</�E]��y�<�R�D�\w(��`��ػy�&���CQ��c?-Z���8%�pG�<Z,iq.��{7��gH/�_L�$7s9�EH����ev����_�5����K��	?�43��f��rMJr�֏�����!�~i�F0a�ƿ'�<��Ɉ\����ڈ�D#F�ظ0 ���p>�$��`��K��>ᛉ4K��g��ж�J�=`�]
۹��#��\bS�goa�G���O����˟��'߻7���uSV�7ɰ�_c� ��         �  x�u��n�@���)�	�0@H�%Uw�j�٤R�j/.q`2���m�~B?�6��6��6!��x$k�+u:!�'	�о	˒Ƚ�h \���"�,�=鎇��lp�aY�s*�`:ʛ@���X5'rp��7K����2�:Gq�4�U�*�Ru,g���ai�sy��C]���pO�_��:�P8��ڕ֘C_����a�WVۂ,4	�� ����F,��Y���%�������%�{�+2̍���I׶֍Z?�j��|'�«q�tDR��(�{%�h_�Fۨ�J�p;��˫�X��>���\hq��,ԙ���S����{q�tQ+M�"�	7�t^��ȁ����@�ݠ7�s���GB�$ϐС�؈,x��Y�>*X�zV>��Ds��v����QcX�$��
"���3�5n-�x aO��%<�v%gI[kڊ�F�&o�A<��+������|�&�T*O�3�`dl�p�8�w|��9ϩ���8z<
�<�П�^�f�I�~��.cxT��qǪ)��ä���us��f�n�X�8��|��)4K��A�c3��c^�����켸�J�(�0�̿�N�K<r�SE黑�}��I<�-�����K��?j�ӧ:Ҧ��?4�Cf*S�F�iW:���I� ��U            x������ � �         S   x�3�LB����4.d�%2�� �g��3B���LPxf(<s��(���n
d��x��.�P,Cq���f�91z\\\  �@u         �   x�=���0D�ݯ�$�����R$�"��Ic%�)Lh����P�{��!x�m3��4��L��pY��ǭsQJ91�2�����0�J2�
�5@~�|��M"?Q��V�� ���.�5��Bg����c�3�Ak$��Z�MfY�&JY�T �D"� �$�H�PH
�����\�ͤ�86�]����=!O     