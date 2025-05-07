import mongoose from 'mongoose';
import dotenv from 'dotenv';
dotenv.config();

const MONGO_URI = ProcessingInstruction.env.MONGO_URI || 'mongodb://localhost:27017/meubanco';

export async function connectDB() {
    try {
        await mongoose.connect(MONGO_URI, {
            useNewUrlParser: true,
            useUnifiedTopology: true
        });
        console.log('Mongo conectado em', MONGO_URI);
    } catch (e) {
        console.log(e)
        process.exit(1);
    }

}