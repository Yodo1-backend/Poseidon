"use strict";

var thrift = require('thrift');
var Calculator = require('./ServiceCaller');
var ttypes = require('./serviceIDL_types');
const assert = require('assert');
var startDate = new Date();
var transport = thrift.TFramedTransport;
var protocol = thrift.TBinaryProtocol;
var connection = thrift.createConnection("172.16.100.96", 30001, {
  transport : transport,
  protocol : protocol
});

connection.on('error', function(err) {
  assert(false, err);
});
var params = new ttypes.ReqParams();
params.num = 10;
// Create a Calculator client with the connection
var client = thrift.createClient(Calculator, connection);
//for(var i = 0;i<100;i++)
//{
  var startDate = new Date();
  var resp = client.INVOKE("aa",params,function(err,message){
    if(err)
    {
      console.log("Error:"+err);
      connection.end();
    }
    else
    {
      console.log("Server Status:"+message.status);
      console.log("Server Duration:"+message.serverTicks);
      connection.end();
      var endDate = new Date();
      console.log("Total Duration:"+(endDate-startDate));
    }
  });
//}

