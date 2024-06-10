package com.javaded.service;

import com.javaded.grpccommon.DataServerGrpc;
import com.javaded.grpccommon.Empty;
import com.javaded.grpccommon.GRPCData;

import com.javaded.model.Data;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GRPCDataService extends DataServerGrpc.DataServerImplBase {

    private final DataService dataService;

    @Override
    public void addData(GRPCData request, StreamObserver<Empty> responseObserver) {
        Data data = new Data(request);
        dataService.handle(data);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

}
