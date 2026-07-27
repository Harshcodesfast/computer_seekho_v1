-- Sample data for the home page (run once after tables are created)

INSERT INTO hero_content (title, subtitle, is_active) VALUES
('Empowering Careers Through IT Excellence',
 'C-DAC ACTS authorized training center in Mumbai — courses for all age groups from 3+ to senior citizens',
 TRUE);

INSERT INTO hero_highlights (title, subtitle, icon, display_order, is_active) VALUES
('Aptitude', 'Logical & Analytical', 'lightbulb', 1, TRUE),
('Technical', 'Industry-Ready Skills', 'code', 2, TRUE),
('Soft Skills', 'Communication & Leadership', 'user', 3, TRUE);

INSERT INTO news_events (title, content, is_active, created_at) VALUES
('100% Placements for e-DAC May 2021 batch!', 'Placement success announcement', TRUE, NOW()),
('New PG-DAC batch starting August 20...', 'Upcoming batch details', TRUE, NOW());
