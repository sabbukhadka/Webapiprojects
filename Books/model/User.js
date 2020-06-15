const mongoose = require('mongoose');
const userSchema = new  mongoose.Schema
({

	username:{
		type: String,
		required:true,
		unique:true,
		minlength: 6,
        maxlength: 12
	},
	password:{
		type: String,
		required:true
	},
	FirstName:{
	type: String,
	required:true
			
	},
	lastName:{
		type: String,
		required:true
	},
	roles:{
		type: String,
		default: 'basic',
		enum:['basic',' manager', 'admin']
		

	}
}, { timestamps: true });
module.exports = mongoose.model('User', userSchema);


