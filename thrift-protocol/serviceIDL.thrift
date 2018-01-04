/***
*
* Define Params Body Transfer by RPC
*
***/

namespace java com.yodo1.poseidon.service

enum ParamType{
    INT = 1,
    FLOAT = 2,
    BOOL = 3,
    STRING = 4,
    LIST = 10,
    MAP = 11
}
struct Param{
    1:ParamType type,
    2:string body,
}

struct ReqParams{
    1:i32 num = 0,
    2:map<string,Param> paramsBody,
}
struct ResParams{
    1:i32 status = 0,
    2:i64 serverTicks = 0,
    3:i32 num = 0,
    4:map<string,Param> paramsBody,
}
service ServiceCaller{
    string ping(),
    i32 getConnectionsNum(),
    ResParams INVOKE(1:string targetService, 2:ReqParams params),
    void INVOKEOneWay(1:string targetService, 2:ReqParams params),
}