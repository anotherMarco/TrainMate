INSERT INTO muscle_groups (id, created_at, updated_at, name)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Chest'),
       (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Back'),
       (3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Legs'),
       (4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Arms'),
       (5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Shoulders'),
       (6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Abs');

INSERT INTO muscles (id, created_at, updated_at, name, muscle_group_id)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Pectoralis major', 1),
       (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Latissimus dorsi', 2),
       (3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Quadriceps femoris', 3),
       (4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Hamstrings', 3),
       (5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Biceps brachii', 4),
       (6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Triceps brachii', 4),
       (7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Deltoid', 5),
       (8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Rectus abdominis', 6),
       (9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Obliquus externus abdominis', 6),
       (10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Obliquus internus abdominis', 6),
       (11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Gluteus maximus', 3),
       (12, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Sartorius', 3),
       (13, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Gastrocnemius', 3),
       (14, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Soleus', 3),
       (15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Tibialis anterior', 3),
       (16, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Trapezius', 5),
       (17, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Rhomboid major', 2),
       (18, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Levator scapulae', 5),
       (19, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Serratus anterior', 1),
       (20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Psoas major', 3);
