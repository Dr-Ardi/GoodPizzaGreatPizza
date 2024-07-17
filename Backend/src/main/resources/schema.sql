DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS sizes;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS restaurant_tables;
DROP TABLE IF EXISTS addables;
DROP TABLE IF EXISTS added;
DROP TABLE IF EXISTS ingredients;

CREATE TABLE ingredients (
    item_id INTEGER,
    ingredient_name VARCHAR(20),
    id BIGINT 
);

CREATE TABLE addables (
    id BIGINT PRIMARY KEY,
    item_type VARCHAR(50),
    sizable BOOLEAN,
    meats BOOLEAN,
    cheeses BOOLEAN,
    sauces BOOLEAN,
    extras BOOLEAN,
    removables BOOLEAN
);

CREATE TABLE added (
    add_type VARCHAR(50),
    added_item VARCHAR(50),
    added_price DOUBLE,
    id BIGINT
);


CREATE TABLE item (
    id BIGINT NOT NULL,
    name VARCHAR(255),
    price DOUBLE NOT NULL,
    priority INTEGER NOT NULL,
    type VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE orders (
    table_number INTEGER,
    priority INTEGER,
    item_name VARCHAR(40),
    extra VARCHAR(255),
    excluded VARCHAR(100),
    quantity INTEGER,
    ordered BOOLEAN,
    order_cost DOUBLE,
    included VARCHAR(100),
    size VARCHAR(50),
    id BIGINT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE restaurant_tables (
    table_number INTEGER NOT NULL,
    occupied BOOLEAN,
    waiter_called BOOLEAN,
    payment VARCHAR(20),
    finished BOOLEAN,
    PRIMARY KEY (table_number)
);

CREATE TABLE sizes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    item_type VARCHAR(20),
    item_size VARCHAR(20),
    added_cost DOUBLE,
    PRIMARY KEY (id)
);


INSERT INTO item (id, name, price, priority, type) VALUES
(1, 'Pepperoni Pizza', 8.5, 4, 'Pizza'),
(2, 'Cheesy Pizza', 8, 4, 'Pizza'),
(3, 'Double Chicken Pizza', 10.6, 4, 'Pizza'),
(4, 'Classic Pizza', 7.5, 4, 'Pizza'),
(5, 'BBQ Chicken Pizza', 11.2, 4, 'Pizza'),
(6, 'Greek Pizza', 8.5, 4, 'Pizza'),
(7, 'Bianca Fina Philadelphia', 12, 4, 'Pizza'),
(8, 'Crosscut Nuggets Pizza', 8.5, 4, 'Pizza'),
(9, 'Meatball Pizza', 9, 4, 'Pizza'),
(10, 'Mushroom Pizza', 7, 4, 'Pizza'),
(11, 'Basic Burger', 5, 4, 'Burger'),
(12, 'Cheese Burger', 6, 4, 'Burger'),
(13, 'American Breakfast', 8.5, 4, 'Burger'),
(14, 'Max Bacon', 7.5, 4, 'Burger'),
(15, 'Drunken Onion', 7.2, 4, 'Burger'),
(16, 'Hell time', 8.7, 4, 'Burger'),
(17, 'Spaghetti Carbonara', 8.2, 4, 'Pasta'),
(18, 'Bolognese Penne', 7, 4, 'Pasta'),
(19, 'Spaghetti with Pesto', 7.3, 4, 'Pasta'),
(20, 'Mac n Cheese', 9, 4, 'Pasta'),
(21, 'Squid Ink Linguine', 10.4, 4, 'Pasta'),
(22, 'French Fries', 2.3, 3, 'Fries'),
(23, 'Tzatziki', 2.7, 3, 'Appetiser'),
(24, 'Tirokafteri', 3, 3, 'Appetiser'),
(25, 'Cheese Sticks', 4.5, 3, 'Appetiser'),
(26, 'Onion Rings', 5.2, 3, 'Appetiser'),
(27, 'Greek Salad', 5.6, 2, 'Salad'),
(28, 'Ceasar Salad', 6, 2, 'Salad'),
(29, 'Cretan Salad', 5.7, 2, 'Salad'),
(30, 'Bread', 2, 1, 'Appetiser'),
(31, 'Water', 1, 1, 'Water'),
(32, 'Coca Cola', 3, 1, 'Soft Drink'),
(33, 'Coca Cola Zero', 3.5, 1, 'Soft Drink'),
(34, 'Coca Cola Light', 3.7, 1, 'Soft Drink'),
(35, 'Ice Tea Peach', 2.5, 1, 'Soft Drink'),
(36, 'Orange Juice', 3, 1, 'Soft Drink'),
(37, 'Apple Juice', 3, 1, 'Soft Drink'),
(38, 'Alfa', 3, 1, 'Beer'),
(39, 'Amstel', 3.7, 1, 'Beer'),
(40, 'Amstel Radrel', 4, 1, 'Beer'),
(41, 'Amstel Free', 4, 1, 'Beer'),
(42, 'Nymfh', 3.5, 1, 'Beer'),
(43, 'Red Wine', 2.7, 1, 'Wine'),
(44, 'Rose Wine', 3, 1, 'Wine'),
(45, 'White Wine', 2.7, 1, 'Wine'),
(46, 'Sweet Red Wine', 3, 1, 'Wine'),
(47, 'Georgiadi Retsina', 3, 1, 'Wine'),
(48, 'Malamatina Retsina', 2.7, 1, 'Wine');

INSERT INTO sizes (id, item_type, item_size, added_cost) VALUES
(1, 'Pizza', 'Small (25.4cm)', 0),
(2, 'Pizza', 'Medium (33cm)', 1.2),
(3, 'Pizza', 'Large (38.1cm)', 3.3),
(4, 'Burger', 'Medium (90gr)', 0),
(5, 'Burger', 'Large (180gr)', 2.4),
(6, 'Beer', '330ml', 0),
(7, 'Beer', '500ml', 1.3),
(8, 'Water', '500ml', 0),
(9, 'Water', '1L', 1.5),
(10, 'Wine', 'Glass', 0),
(11, 'Wine', '250ml', 1.2),
(12, 'Wine', '500ml', 3.3),
(13, 'Wine', '1L', 4),
(14, 'Fries', 'Medium (70gr)', 0),
(15, 'Fries', 'Large (140gr)', 1.6);

INSERT INTO restaurant_tables (table_number, occupied, waiter_called, payment, finished) VALUES
(5, FALSE, FALSE, 'Cash', FALSE),
(7, FALSE, FALSE, 'Cash', FALSE),
(8, FALSE, FALSE, 'Cash', FALSE),
(9, FALSE, FALSE, 'Cash', FALSE),
(10, FALSE, FALSE, 'Cash', FALSE),
(11, FALSE, FALSE, 'Cash', FALSE),
(12, FALSE, FALSE, 'Cash', FALSE),
(13, FALSE, FALSE, 'Cash', FALSE),
(14, FALSE, FALSE, 'Cash', FALSE),
(16, FALSE, FALSE, 'Cash', FALSE),
(17, FALSE, FALSE, 'Cash', FALSE),
(18, FALSE, FALSE, 'Cash', FALSE),
(19, FALSE, FALSE, 'Cash', FALSE),
(20, FALSE, FALSE, 'Cash', FALSE),
(1, FALSE, FALSE, 'Cash', FALSE),
(2, FALSE, FALSE, 'Cash', FALSE),
(15, FALSE, FALSE, 'Cash', FALSE),
(4, FALSE, FALSE, 'Cash', FALSE),
(6, FALSE, FALSE, 'Cash', FALSE),
(3, FALSE, FALSE, 'Cash', FALSE);

INSERT INTO addables (id, item_type, sizable, meats, cheeses, sauces, extras, removables) VALUES
(1, 'Burger', true, false, true, true, true, true),
(2, 'Pasta', false, false, false, false, false, false),
(3, 'Appetiser', false, false, false, true, false, false),
(4, 'Fries', true, false, false, true, false, false),
(5, 'Water', true, false, false, false, false, false),
(6, 'Wine', true, false, false, false, false, false),
(7, 'Soft Drink', false, false, false, false, false, false),
(8, 'Salad', false, false, false, false, false, true),
(9, 'Beer', true, false, false, false, false, false),
(10, 'Pizza', true, true, true, true, true, true);

INSERT INTO added (add_type, added_item, added_price, id) VALUES
('meat', 'turkey', 0.6, 1),
('meat', 'pepperoni', 0.8, 2),
('meat', 'bacon', 1.2, 3),
('meat', 'mortadhela', 1.0, 4),
('meat', 'pariza', 0.9, 5),
('meat', 'ham', 0.75, 6),
('cheese', 'american', 0.5, 7),
('cheese', 'feta', 0.65, 8),
('cheese', 'cheddar', 0.8, 9),
('cheese', 'gouda', 0.6, 10),
('cheese', 'mozzarella', 0.55, 11),
('sauce', 'mustard', 0.3, 12),
('sauce', 'ketchup', 0.4, 13),
('sauce', 'BBQ sauce', 0.8, 14),
('sauce', 'hot sauce', 0.7, 15),
('sauce', 'mayonnaise', 0.65, 16),
('extra', 'lettuce', 0.5, 17),
('extra', 'tomato', 0.85, 18),
('extra', 'corn', 0.75, 19),
('extra', 'pineapple', 0.8, 20),
('extra', 'mushrooms', 0.6, 21),
('extra', 'egg', 1.1, 22),
('extra', 'peppers', 0.4, 23),
('extra', 'hot peppers', 0.75, 24);

INSERT INTO ingredients (item_id, ingredient_name, id) VALUES
(1, 'pepperoni', 1),
(1, 'tomato sauce', 2),
(1, 'gouda cheese', 3),
(2, 'feta cheese', 4),
(2, 'tomato sauce', 5),
(2, 'gouda cheese', 6),
(2, 'cream cheese', 7),
(3, 'tomato sauce', 8),
(3, 'mozzarella', 9),
(3, 'chicken', 10),
(3, 'chicken nuggets', 11),
(4, 'tomato sauce', 12),
(4, 'mozzarella', 13),
(4, 'bazil', 14),
(5, 'gouda cheese', 15),
(5, 'tomato sauce', 16),
(5, 'chicken', 17),
(5, 'bbq sauce', 18),
(6, 'feta cheese', 19),
(6, 'tomato sauce', 20),
(6, 'mozzarella', 21),
(6, 'tomatoes', 22),
(7, 'philadelfia', 23),
(7, 'mozzarella', 24),
(7, 'bazil', 25),
(7, 'tomato sauce', 26),
(8, 'chicken nuggets', 27),
(8, 'tomato sauce', 28),
(8, 'gouda cheese', 29),
(9, 'meatballs', 30),
(9, 'tomato sauce', 31),
(9, 'mozzarella', 32),
(10, 'pepperoni', 33),
(10, 'tomato sauce', 34),
(10, 'mozzarella', 35),
(10, 'mushrooms', 36),
(11, 'Hambuger Patty', 37),
(11, 'Cabbage', 38),
(11, 'Tomato', 39),
(11, 'Mayonnaise', 40),
(12, 'Mayonnaise', 41),
(13, 'Mayonnaise', 42),
(13, 'BBQ Sauce', 43),
(14, 'BBQ Sauce', 44),
(15, 'BBQ Sauce', 45),
(12, 'Gouda Cheese', 46),
(12, 'Hambuger Patty', 47),
(12, 'Cabbage', 48),
(12, 'Tomato', 49),
(13, 'Hambuger Patty', 50),
(13, 'Cabbage', 51),
(13, 'Tomato', 52),
(13, 'Gouda Cheese', 53),
(13, 'Bacon', 54),
(13, 'Fried Egg', 55),
(14, 'Hambuger Patty', 56),
(14, 'Cabbage', 57),
(14, 'Tomato', 58),
(14, 'Gouda Cheese', 59),
(14, 'Double Bacon', 60),
(14, 'Onion', 61),
(15, 'Tomato', 62),
(15, 'Hambuger Patty', 63),
(15, 'Cabbage', 64),
(15, 'Mozzarella', 65),
(15, 'Caramellized Onions', 66),
(15, 'Onion Ring', 67),
(16, 'Chicken Burger', 68),
(16, 'BBQ Sauce', 69),
(16, 'Hot Sauce', 70),
(16, 'Ghost Peppers', 71),
(16, 'Cabbage', 72),
(16, 'Cheddar', 73),
(27, 'Tomatoes', 74),
(27, 'Cucumbers', 75),
(27, 'Red onions', 76),
(27, 'Feta cheese', 77),
(27, 'Olives', 78),
(28, 'Lettuce', 79),
(28, 'Croutons', 80),
(28, 'Parmesan cheese', 81),
(28, 'Caesar dressing', 82),
(29, 'Barley rusk', 83),
(29, 'Tomatoes', 84),
(29, 'Feta cheese', 85),
(29, 'Olives', 86),
(29, 'Capers', 87),
(17, 'Cheese cream', 88),
(17, 'Bacon', 89),
(17, 'Pariza', 90),
(18, 'Tomato sauce', 91),
(18, 'Minced meat', 92),
(20, 'Multiple Cheeses', 93),
(19, 'Pesto', 94),
(21, 'Parmesan cheese', 95),
(21, 'Squid Ink', 96),
(21, 'Tomatoes', 97),
(21, 'Parmesan cheese', 98);