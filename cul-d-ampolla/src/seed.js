const mongoose = require('mongoose');
const faker = require('faker');
const { Customer, Glasses, Sale } = require('./models');

require('dotenv').config();

const MONGODB_URI = process.env.MONGODB_URI || 'mongodb://localhost:27017/cul-d-ampolla';

mongoose.connect(MONGODB_URI)
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('Could not connect to MongoDB:', err));


const glassBrands = [
  'Ray-Ban', 'Oakley', 'Gucci', 'Prada', 'Versace', 
  'Armani', 'Tom Ford', 'Dolce & Gabbana', 'Persol', 'Oliver Peoples'
];


const glassProviders = [
  'Goggles Associated SL', 'Luxottica Group', 'Safilo Group', 
  'Marchon Eyewear', 'De Rigo Vision', 'Marcolin', 'Silhouette International',
  'Maui Jim', 'Kering Eyewear', 'Essilor International'
];

const generateGlasses = () => ({
  brand: faker.random.arrayElement(glassBrands),
  mountingType: ['floating', 'paste', 'metal'][Math.floor(Math.random() * 3)],
  price: parseFloat((Math.random() * 500 + 50).toFixed(2)),
  provider: faker.random.arrayElement(glassProviders)
});

const generateCustomer = () => ({
  name: faker.name.findName(),
  postalAddress: {
    street: faker.address.streetAddress(),
    city: faker.address.city(),
    postalCode: faker.address.zipCode(),
    country: faker.address.country()
  },
  phoneNumber: faker.phone.phoneNumber(),
  email: faker.internet.email(),
  registrationDate: faker.date.past(2)
});

async function seedDatabase() {
  try {
    
    await Customer.deleteMany({});
    await Glasses.deleteMany({});
    await Sale.deleteMany({});

    
    console.log('Creating customers...');
    const customers = Array(20).fill().map(generateCustomer);
    const savedCustomers = await Customer.insertMany(customers);
    
   
    console.log('Adding customer recommendations...');
    for (let i = 5; i < savedCustomers.length; i++) {
     
      const recommenderId = savedCustomers[Math.floor(Math.random() * 5)]._id;
      await Customer.findByIdAndUpdate(savedCustomers[i]._id, { recommendedBy: recommenderId });
    }

    
    console.log('Creating glasses inventory...');
    const glasses = Array(30).fill().map(generateGlasses);
    const savedGlasses = await Glasses.insertMany(glasses);

    
    console.log('Creating sales records...');
    const sales = [];
    
    
    for (const customer of savedCustomers) {
      const numberOfPurchases = Math.floor(Math.random() * 3) + 1;
      
      for (let i = 0; i < numberOfPurchases; i++) {
        
        const randomGlasses = savedGlasses[Math.floor(Math.random() * savedGlasses.length)];
        
        const hasRecommendation = Math.random() > 0.5;
        let recommendedBy = null;
        
        if (hasRecommendation) {
          const recommender = savedCustomers[Math.floor(Math.random() * savedCustomers.length)];
          if (recommender._id.toString() !== customer._id.toString()) {
            recommendedBy = recommender._id;
          }
        }
        
        sales.push({
          customer: customer._id,
          glasses: randomGlasses._id,
          saleDate: faker.date.past(1),
          recommendedBy
        });
      }
    }
    
    await Sale.insertMany(sales);

    console.log('Database seeded successfully!');
    console.log(`Created ${savedCustomers.length} customers`);
    console.log(`Created ${savedGlasses.length} glasses`);
    console.log(`Created ${sales.length} sales records`);

  } catch (error) {
    console.error('Error seeding database:', error);
  } finally {
    mongoose.connection.close();
  }
}

seedDatabase();