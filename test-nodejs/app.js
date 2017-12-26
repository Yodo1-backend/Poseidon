"use strict";

var thrift = require('thrift');
var Calculator = require('./ServiceCaller');
var ttypes = require('./serviceIDL_types');
const assert = require('assert');

var transport = thrift.TBufferedTransport;
var protocol = thrift.TBinaryProtocol;
var connection = thrift.createConnection("172.16.100.96", 30001, {
  transport : transport,
  protocol : protocol
});

connection.on('error', function(err) {
  assert(false, err);
});

// Create a Calculator client with the connection
var client = thrift.createClient(Calculator, connection);

var resp = client.INVOKE(null,function(err,message){
  if(err)
  {
    console.log("Error:"+err);
    connection.end();
  }
  else
  {
    var b = message;
    var c = b;
    connection.end();
  }
});