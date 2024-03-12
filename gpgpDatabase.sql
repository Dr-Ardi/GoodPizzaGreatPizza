PGDMP      	                |            GoodPizzaGP    16.1    16.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
    public          postgres    false    218   D                  0    16546    orders 
   TABLE DATA           �   COPY public.orders (table_number, priority, item_name, extra, excluded, quantity, ordered, order_cost, included, size, id) FROM stdin;
    public          postgres    false    217   �"                 0    16538    restaurant_tables 
   TABLE DATA           e   COPY public.restaurant_tables (table_number, occupied, waiter_called, payment, finished) FROM stdin;
    public          postgres    false    216   �#                 0    16624    sizes 
   TABLE DATA           E   COPY public.sizes (id, item_type, item_size, added_cost) FROM stdin;
    public          postgres    false    223   P$                  0    0    item_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.item_seq', 1, false);
          public          postgres    false    219                       0    0 	   order_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.order_seq', 18, true);
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
a�	����0E��z̬�0?rZ��ǝ��T�.���/�n�Q��R�b�{            x�eT˒�0<_�/H����z����k��s0�U��*��3��M�zzz��x>���B0��F2�m�ikΪ#�� �/4�q�5�RȻ;�}r��^�¶����N���mӠ�A��%˺J~m���S�$��S(�f�n�Q�~�v��~�:��|-����Ђ��^2_)(_<�t�M��VS�1�e�p�\�f��͊�Y}TRv:Cx�]iT�����̎�%oЅ���E�=d*�<����/�yk�,A��s�ns^��f��#~��3-^�|u2�+ٻ�E	����q��b�,�Lb�J,�gi�٨��{/\�N%�r:+��_l�(�W26Hi�"�!zr���xm��"U�Y|�-�I3�ףԆ�����{k��u�Ue�Y���le���	|�y�A�e��3xo�?W��O4fx�9씴f��p�C�����9%�j��
ڇj��'g/�߰�$s(��*��Gqx�D暋+}�|T������h.���h{�q�%:�����iyQ�8B���ُ��������[�W�         �  x�u��n�@���)�	�0@H�%Uw�j�٤R�j/.q`2���m�~B?�6��6��6!��x$k�+u:!�'	�о	˒Ƚ�h \���"�,�=鎇��lp�aY�s*�`:ʛ@���X5'rp��7K����2�:Gq�4�U�*�Ru,g���ai�sy��C]���pO�_��:�P8��ڕ֘C_����a�WVۂ,4	�� ����F,��Y���%�������%�{�+2̍���I׶֍Z?�j��|'�«q�tDR��(�{%�h_�Fۨ�J�p;��˫�X��>���\hq��,ԙ���S����{q�tQ+M�"�	7�t^��ȁ����@�ݠ7�s���GB�$ϐС�؈,x��Y�>*X�zV>��Ds��v����QcX�$��
"���3�5n-�x aO��%<�v%gI[kڊ�F�&o�A<��+������|�&�T*O�3�`dl�p�8�w|��9ϩ���8z<
�<�П�^�f�I�~��.cxT��qǪ)��ä���us��f�n�X�8��|��)4K��A�c3��c^�����켸�J�(�0�̿�N�K<r�SE黑�}��I<�-�����K��?j�ӧ:Ҧ��?4�Cf*S�F�iW:���I� ��U           x����N�@�g�)<	E���e$E�*�#�{q�S.�tq��q�Zu����Y����2x�If�: H��4�hf��ho����qy�,6P�8�d��B͸2�7`�:���a:z�]c[����3��D�ZF'h'A�ˀ&��;��/�F�s����ԣm�G��X�Rh,K
�Z���<s�WYf;��n��{��#9����@w?@g�"0����^�?%zQ���H���T9R����I�����l��8��o%�c         Q   x�U�;�0�:{���5hh"zr��#7~�d�}��>����cul��q84B�B��!t!B��"�$[�m?Z\CD|{@g         �   x�=���0D�ݯ�$�����R$�"��Ic%�)Lh����P�{��!x�m3��4��L��pY��ǭsQJ91�2�����0�J2�
�5@~�|��M"?Q��V�� ���.�5��Bg����c�3�Ak$��Z�MfY�&JY�T �D"� �$�H�PH
�����\�ͤ�86�]����=!O     