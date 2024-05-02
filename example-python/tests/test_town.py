import unittest

from main.town import Town


class TestTown(unittest.TestCase):
    # before all tests
    @classmethod
    def setUpClass(cls):
        cls.test_value1_name = "Dresden"
        cls.test_value1_residents = 556780
        cls.test_value2_name = "Leipzig"
        cls.test_value2_residents = 593145

    # after all tests
    @classmethod
    def tearDownClass(cls):
        pass

    # before each test
    def setUp(self):
        pass

    # after each test
    def tearDown(self):
        pass

    def test_town_values(self):
        """T01: Set and get equals town name and residents"""

        # constructor equals get
        t = Town(self.test_value1_name, self.test_value1_residents)
        self.assertEqual(t.name, self.test_value1_name)
        self.assertEqual(t.residents, self.test_value1_residents)
        # set equals get
        t.name = self.test_value2_name
        t.residents = self.test_value2_residents
        self.assertEqual(t.name, self.test_value2_name)
        self.assertEqual(t.residents, self.test_value2_residents)

    def test_town_name_error_values(self):
        """T02: Set correct town name
        - name: cannot be null, empty or contain only spaces
        """

        # constructor
        self.assertRaises(ValueError, Town, None, self.test_value1_residents)
        self.assertRaises(ValueError, Town, "", self.test_value1_residents)
        self.assertRaises(ValueError, Town, "  ", self.test_value1_residents)
        # set
        t = Town(self.test_value1_name, self.test_value1_residents)
        with self.assertRaises(ValueError):
            t.name = None
        with self.assertRaises(ValueError):
            t.name = ""
        with self.assertRaises(ValueError):
            t.name = "  "

    def test_town_residents_error_value(self):
        """T03: Set correct town residents
        - residents: cannot be less 0
        """

        # constructor equals get
        t = Town(self.test_value1_name, -1)
        self.assertFalse(t.residents < 0)
        # set equals get
        t.residents = -2
        self.assertFalse(t.residents < 0)

    def test_town_str(self):
        """T04: Get correct town as human readable string"""

        t = Town(self.test_value1_name, self.test_value1_residents)
        template = f"The town {self.test_value1_name} has {self.test_value1_residents} residents."

        self.assertEqual(str(t), template)

    def test_town_repr(self):
        """T05: Get correct town as object representation string"""

        t = Town(self.test_value1_name, self.test_value1_residents)
        template = f"Town({self.test_value1_name!r}, {self.test_value1_residents!r})"

        self.assertEqual(repr(t), template)


if __name__ == "__main__":
    unittest.main()
