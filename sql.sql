CREATE TABLE ISSUESLISTS (
                             ID INT AUTO_INCREMENT PRIMARY KEY,
                             NAME VARCHAR(255) NOT NULL
);

SELECT * FROM ISSUESLISTS
;

CREATE TABLE ISSUES (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        ISSUESLIST_ID INT,
                        SUMMARY VARCHAR(255) NOT NULL,
                        DESCRIPTION TEXT,
                        USER_ID_ASSIGNEDTO INT,
                        FOREIGN KEY (ISSUESLIST_ID) REFERENCES ISSUESLISTS(ID)
);

INSERT INTO ISSUESLISTS (NAME) VALUES
                                   ('ToDo'),
                                   ('In progress'),
                                   ('Done');

INSERT INTO ISSUES (ISSUESLIST_ID, SUMMARY, DESCRIPTION, USER_ID_ASSIGNEDTO) VALUES
                                                                                 (1, 'Przygotowanie prezentacji', 'Przygotować prezentację na spotkanie zespołu.', 1),
                                                                                 (1, 'Zakup artykułów biurowych', 'Zakupić artykuły biurowe: papier, długopisy, teczki.', 2),
                                                                                 (1, 'Napisanie raportu', 'Napisać raport z wyników badań.', 3),
                                                                                 (1, 'Planowanie projektu', 'Rozpocząć planowanie nowego projektu.', 1),
                                                                                 (1, 'Przygotowanie harmonogramu', 'Przygotować harmonogram spotkań z klientami.', 2),
                                                                                 (2, 'Implementacja funkcji logowania', 'Rozpocząć implementację funkcji logowania w aplikacji.', 3),
                                                                                 (2, 'Testowanie oprogramowania', 'Przeprowadzić testy jednostkowe nowych funkcji.', 1),
                                                                                 (2, 'Aktualizacja dokumentacji', 'Zaktualizować dokumentację techniczną aplikacji.', 2),
                                                                                 (2, 'Optymalizacja kodu', 'Dokonać optymalizacji istniejącego kodu źródłowego.', 3),
                                                                                 (2, 'Przygotowanie prezentacji', 'Przygotować prezentację dla zespołu programistycznego.', 1),
                                                                                 (3, 'Zakończenie projektu X', 'Finalizacja i oddanie projektu X klientowi.', 2),
                                                                                 (3, 'Raport końcowy', 'Przygotowanie raportu końcowego z wykonanych działań.', 3),
                                                                                 (3, 'Sprzątanie biura', 'Sprzątanie biura po zakończonym projekcie.', 1),
                                                                                 (3, 'Prezentacja wyników', 'Przygotowanie prezentacji dla zarządu firmy.', 2),
                                                                                 (3, 'Podsumowanie miesiąca', 'Podsumowanie działań wykonanych w ostatnim miesiącu.', 3);

SELECT * FROM ISSUES;