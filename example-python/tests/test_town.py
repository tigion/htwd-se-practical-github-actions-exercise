import unittest

from main.town import Town


class TestTown(unittest.TestCase):
    # before all tests
    @classmethod
    def setUpClass(cls):
        cls.testValue1Name = "Dresden"
        cls.testValue1Residents = 556780
        cls.testValue2Name = "Leipzig"
        cls.testValue2Residents = 593145

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

    def testTownValues(self):
        """T01: Set and get equals town name and residents"""

        # constructor equals get
        t = Town(self.testValue1Name, self.testValue1Residents)
        self.assertEqual(t.name, self.testValue1Name)
        self.assertEqual(t.residents, self.testValue1Residents)
        # set equals get
        t.name = self.testValue2Name
        t.residents = self.testValue2Residents
        self.assertEqual(t.name, self.testValue2Name)
        self.assertEqual(t.residents, self.testValue2Residents)

    def testTownNameErrorValues(self):
        """T02: Set correct town name
        - name: cannot be null, empty or contain only spaces
        """

        # constructor
        self.assertRaises(ValueError, Town, None, self.testValue1Residents)
        self.assertRaises(ValueError, Town, "", self.testValue1Residents)
        self.assertRaises(ValueError, Town, "  ", self.testValue1Residents)
        # set
        t = Town(self.testValue1Name, self.testValue1Residents)
        with self.assertRaises(ValueError):
            t.name = None
        with self.assertRaises(ValueError):
            t.name = ""
        with self.assertRaises(ValueError):
            t.name = "  "

    def testTownResidentsErrorValue(self):
        """T03: Set correct town residents
        - residents: cannot be less 0
        """

        # constructor equals get
        t = Town(self.testValue1Name, -1)
        self.assertFalse(t.residents < 0)
        # set equals get
        t.residents = -2
        self.assertFalse(t.residents < 0)

    def testTownToString(self):
        """T04: Get correct town as string"""

        t = Town(self.testValue1Name, self.testValue1Residents)
        template = (
            "Town [name="
            + self.testValue1Name
            + ", residents="
            + str(self.testValue1Residents)
            + "]"
        )
        self.assertEqual(t.toString(), template)


if __name__ == "__main__":
    unittest.main()
