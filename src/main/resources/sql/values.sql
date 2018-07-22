INSERT INTO `recruiting-server`.companies (id, name, contact_email, registration_date, foundation_date) VALUES
  ('2f842e97-8588-4311-9214-6431b1e0fb3b', 'Thumbtack Technology', 'contact@thumbtack.com', '2013-07-22 16:46:42',
   '2010-07-22 16:46:38');
INSERT INTO `recruiting-server`.companies (id, name, contact_email, registration_date, foundation_date) VALUES
  ('52190722-b7a9-4a39-be80-c6b11f032640', '7bits', 'contact@sevenbits.com', '2013-07-22 16:46:42',
   '2010-07-22 16:46:38');
INSERT INTO `recruiting-server`.companies (id, name, contact_email, registration_date, foundation_date) VALUES
  ('5747d63c-fd10-4859-b6b3-606bbdf890ca', 'ADCI Solutions', 'contact@adci.com', '2014-11-28 16:47:47',
   '2015-07-24 16:46:38');
INSERT INTO `recruiting-server`.companies (id, name, contact_email, registration_date, foundation_date) VALUES
  ('7ca9602e-9f26-45ff-86c0-fd4c5879bbb6', 'Hello World Technologies', 'contact@hwdt.com', '2015-12-22 16:46:42',
   '2012-05-22 16:46:38');
INSERT INTO `recruiting-server`.companies (id, name, contact_email, registration_date, foundation_date) VALUES
  ('fe046afa-55bc-424d-9a4b-db50ba74268b', 'Live Typing', 'contact@livetyping.com', '2014-07-22 16:46:42',
   '2013-07-22 16:46:38');


INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('049c714e-5d69-4f36-ba59-2e5b6244463e', 'Senior Java Full-Stack Developer', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', '2f842e97-8588-4311-9214-6431b1e0fb3b', 0, '2017-09-25 16:54:14');
INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('44429dbf-3069-4247-b456-3797b18af08a', 'Python Developer', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', 'fe046afa-55bc-424d-9a4b-db50ba74268b', 0, '2017-09-25 16:54:14');
INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('6d1209ea-4d54-4a88-82d1-8327fae22287', 'Middle FrontEnd Developer', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', '2f842e97-8588-4311-9214-6431b1e0fb3b', 0, '2017-09-25 16:54:14');
INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('70f02834-eedc-4ac0-868b-2269dcd96e12', 'C++ Senior Developer', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', '7ca9602e-9f26-45ff-86c0-fd4c5879bbb6', 0, '2017-09-25 16:54:14');
INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('c0785210-b0b6-4993-ba92-6359834e59c7', 'Junior Java Sql Developer', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', '52190722-b7a9-4a39-be80-c6b11f032640', 0, '2017-09-25 16:54:14');
INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('cf2c2fee-699b-4487-8643-e38e9be5f038', 'C++ Junior Dev', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', '52190722-b7a9-4a39-be80-c6b11f032640', 0, '2017-09-25 16:54:14');
INSERT INTO `recruiting-server`.vacancies (id, name, description, author_id, hidden, creation_date)
VALUES ('e16bfbc5-78eb-4fe4-a5c8-cd656fe3b021', 'Junior Java Sql Developer', 'short and fascinating
description part of this vacancy
</cut>
Full and detail description of vacancy', '2f842e97-8588-4311-9214-6431b1e0fb3b', 0, '2017-09-25 16:54:14');


INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('049c714e-5d69-4f36-ba59-2e5b6244463e', 23000, 'PER_MONTH', 'RUB');
INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('44429dbf-3069-4247-b456-3797b18af08a', 25000, 'CONTRACTUAL', 'RUB');
INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('6d1209ea-4d54-4a88-82d1-8327fae22287', 27000, 'PER_MONTH', 'RUB');
INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('70f02834-eedc-4ac0-868b-2269dcd96e12', 17000, 'CONTRACTUAL', 'RUB');
INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('c0785210-b0b6-4993-ba92-6359834e59c7', 25000, 'PER_MONTH', 'RUB');
INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('cf2c2fee-699b-4487-8643-e38e9be5f038', 280000, 'PER_YEAR', 'RUB');
INSERT INTO `recruiting-server`.salaries (vacancy_id, amount, type, currency)
VALUES ('e16bfbc5-78eb-4fe4-a5c8-cd656fe3b021', 16260, 'PER_MONTH', 'RUB');

INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('049c714e-5d69-4f36-ba59-2e5b6244463e', 'Java', 7, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('049c714e-5d69-4f36-ba59-2e5b6244463e', 'React js', 8, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('049c714e-5d69-4f36-ba59-2e5b6244463e', 'Spring', 5, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('44429dbf-3069-4247-b456-3797b18af08a', 'C++', 5, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('44429dbf-3069-4247-b456-3797b18af08a', 'Memcached', 9, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('6d1209ea-4d54-4a88-82d1-8327fae22287', 'Java', 1, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('6d1209ea-4d54-4a88-82d1-8327fae22287', 'Python', 7, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('70f02834-eedc-4ac0-868b-2269dcd96e12', 'C++', 6, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('70f02834-eedc-4ac0-868b-2269dcd96e12', 'Java', 3, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('70f02834-eedc-4ac0-868b-2269dcd96e12', 'Maven', 2, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('c0785210-b0b6-4993-ba92-6359834e59c7', 'CSS', 6, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('c0785210-b0b6-4993-ba92-6359834e59c7', 'HTML', 5, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('cf2c2fee-699b-4487-8643-e38e9be5f038', 'Java Script', 8, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('cf2c2fee-699b-4487-8643-e38e9be5f038', 'React', 5, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('e16bfbc5-78eb-4fe4-a5c8-cd656fe3b021', 'C', 2, 0);
INSERT INTO `recruiting-server`.skill_requirements (vacancy_id, name, level, important)
VALUES ('e16bfbc5-78eb-4fe4-a5c8-cd656fe3b021', 'C++', 4, 0);