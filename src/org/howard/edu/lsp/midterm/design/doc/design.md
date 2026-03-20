Class: Order
Responsibilities:
- Store order data (customer name, email, item, price)
- Provide access to order details

Collaborators:
- OrderProcessor

---

Class: OrderProcessor
Responsibilities:
- Coordinate order processing workflow

Collaborators:
- Order
- TaxCalculator
- ReceiptPrinter
- OrderRepository
- EmailService
- DiscountService
- Logger

---

Class: TaxCalculator
Responsibilities:
- Calculate tax and total price

Collaborators:
- Order

---

Class: ReceiptPrinter
Responsibilities:
- Print receipt

Collaborators:
- Order

---

Class: OrderRepository
Responsibilities:
- Save order to file

Collaborators:
- Order

---

Class: EmailService
Responsibilities:
- Send confirmation email

Collaborators:
- Order

---

Class: DiscountService
Responsibilities:
- Apply discounts

Collaborators:
- Order

---

Class: Logger
Responsibilities:
- Log activity

Collaborators:
- OrderProcessor