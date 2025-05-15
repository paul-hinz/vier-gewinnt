## Generate files from proto in JS

For Entities:
Node Frontend\node_modules\@grpc\proto-loader\build\bin\proto-loader-gen-types.js --grpcLib=@grpc/grpc-js --outDir=Frontend/src/app/grpc protos/Game.proto

For gRPC specific files:
C:\Users\Dominik\protoc.exe -I=Frontend/src/app/grpc --js_out=import_style=commonjs:Frontend/src/app/grpc --grpc-web_out=import_style=typescript,mode=grpcwebtext:Frontend/src/app/grpc --proto_path=protos Game.proto

You might have to install protoc-gen-grpc-web and protoc-gen-js globally with:
npm install -g protoc-gen-js
npm install -g protoc-gen-grpc-web