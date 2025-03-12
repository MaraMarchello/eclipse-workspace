const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const { Customer, Glasses, Sale } = require('./models');
require('dotenv').config();
mongoose.set('strictQuery', false);

const app = express();
const PORT = process.env.PORT || 3000;
const MONGODB_URI = process.env.MONGODB_URI || 'mongodb://localhost:27017/cul-d-ampolla';

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static('public'));

mongoose.connect(MONGODB_URI)
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('Could not connect to MongoDB:', err));

app.get('/api/customers', async (req, res) => {
  try {
    const customers = await Customer.find().populate('recommendedBy');
    res.json(customers);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/customers/:id', async (req, res) => {
  try {
    const customer = await Customer.findById(req.params.id).populate('recommendedBy');
    if (!customer) {
      return res.status(404).json({ message: 'Customer not found' });
    }
    res.json(customer);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.post('/api/customers', async (req, res) => {
  try {
    const customer = new Customer(req.body);
    const savedCustomer = await customer.save();
    res.status(201).json(savedCustomer);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
});

app.put('/api/customers/:id', async (req, res) => {
  try {
    const updatedCustomer = await Customer.findByIdAndUpdate(
      req.params.id, 
      req.body, 
      { new: true, runValidators: true }
    );
    if (!updatedCustomer) {
      return res.status(404).json({ message: 'Customer not found' });
    }
    res.json(updatedCustomer);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
});

app.delete('/api/customers/:id', async (req, res) => {
  try {
    const customer = await Customer.findByIdAndDelete(req.params.id);
    if (!customer) {
      return res.status(404).json({ message: 'Customer not found' });
    }
    await Sale.deleteMany({ customer: req.params.id });
    res.json({ message: 'Customer deleted successfully' });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/glasses', async (req, res) => {
  try {
    const glasses = await Glasses.find();
    res.json(glasses);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/glasses/:id', async (req, res) => {
  try {
    const glasses = await Glasses.findById(req.params.id);
    if (!glasses) {
      return res.status(404).json({ message: 'Glasses not found' });
    }
    res.json(glasses);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.post('/api/glasses', async (req, res) => {
  try {
    const glasses = new Glasses(req.body);
    const savedGlasses = await glasses.save();
    res.status(201).json(savedGlasses);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
});

app.put('/api/glasses/:id', async (req, res) => {
  try {
    const updatedGlasses = await Glasses.findByIdAndUpdate(
      req.params.id, 
      req.body, 
      { new: true, runValidators: true }
    );
    if (!updatedGlasses) {
      return res.status(404).json({ message: 'Glasses not found' });
    }
    res.json(updatedGlasses);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
});

app.delete('/api/glasses/:id', async (req, res) => {
  try {
    const glasses = await Glasses.findByIdAndDelete(req.params.id);
    if (!glasses) {
      return res.status(404).json({ message: 'Glasses not found' });
    }
    await Sale.deleteMany({ glasses: req.params.id });
    res.json({ message: 'Glasses deleted successfully' });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});


app.get('/api/sales', async (req, res) => {
  try {
    const sales = await Sale.find()
      .populate('customer')
      .populate('glasses')
      .populate('recommendedBy');
    res.json(sales);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/sales/:id', async (req, res) => {
  try {
    const sale = await Sale.findById(req.params.id)
      .populate('customer')
      .populate('glasses')
      .populate('recommendedBy');
    if (!sale) {
      return res.status(404).json({ message: 'Sale not found' });
    }
    res.json(sale);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.post('/api/sales', async (req, res) => {
  try {
    const sale = new Sale(req.body);
    const savedSale = await sale.save();
    const populatedSale = await Sale.findById(savedSale._id)
      .populate('customer')
      .populate('glasses')
      .populate('recommendedBy');
    res.status(201).json(populatedSale);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
});

app.put('/api/sales/:id', async (req, res) => {
  try {
    const updatedSale = await Sale.findByIdAndUpdate(
      req.params.id, 
      req.body, 
      { new: true, runValidators: true }
    )
      .populate('customer')
      .populate('glasses')
      .populate('recommendedBy');
    if (!updatedSale) {
      return res.status(404).json({ message: 'Sale not found' });
    }
    res.json(updatedSale);
  } catch (error) {
    res.status(400).json({ message: error.message });
  }
});

app.delete('/api/sales/:id', async (req, res) => {
  try {
    const sale = await Sale.findByIdAndDelete(req.params.id);
    if (!sale) {
      return res.status(404).json({ message: 'Sale not found' });
    }
    res.json({ message: 'Sale deleted successfully' });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/customers/:id/sales', async (req, res) => {
  try {
    const sales = await Sale.find({ customer: req.params.id })
      .populate('glasses')
      .populate('recommendedBy');
    res.json(sales);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/customers/:id/recommended', async (req, res) => {
  try {
    const recommendedCustomers = await Customer.find({ recommendedBy: req.params.id });
    res.json(recommendedCustomers);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/sales/by-brand/:brand', async (req, res) => {
  try {
    const glasses = await Glasses.find({ brand: req.params.brand });
    const glassesIds = glasses.map(g => g._id);
    const sales = await Sale.find({ glasses: { $in: glassesIds } })
      .populate('customer')
      .populate('glasses')
      .populate('recommendedBy');
    res.json(sales);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.get('/api/sales/by-provider/:provider', async (req, res) => {
  try {
    const glasses = await Glasses.find({ provider: req.params.provider });
    const glassesIds = glasses.map(g => g._id);
    const sales = await Sale.find({ glasses: { $in: glassesIds } })
      .populate('customer')
      .populate('glasses')
      .populate('recommendedBy');
    res.json(sales);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});

module.exports = app;