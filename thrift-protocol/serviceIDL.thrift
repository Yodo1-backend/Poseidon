/***
*
* Define Params Body Transfer by RPC
*
***/

include "shard.thrift"
namespace java Poseidon

service ServiceCaller extends shard.ShardService {
    Param INVOKE(1:Params params)
}