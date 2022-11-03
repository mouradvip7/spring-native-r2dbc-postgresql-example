package com.example.demo.hints;


import io.netty.channel.DefaultChannelId;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Limits;
import io.netty.channel.unix.Socket;
import io.netty.handler.codec.compression.BrotliDecoder;
import io.netty.handler.codec.http2.CleartextHttp2ServerUpgradeHandler;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2ServerUpgradeCodec;
import io.netty.handler.ssl.OpenSslAsyncPrivateKeyMethod;
import io.netty.handler.ssl.OpenSslPrivateKeyMethod;
import io.netty.handler.ssl.ReferenceCountedOpenSslEngine;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.util.internal.PlatformDependent;
import org.springframework.nativex.hint.InitializationHint;
import org.springframework.nativex.hint.InitializationTime;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.type.NativeConfiguration;

@NativeHint(trigger = DefaultChannelId.class, initialization = {
        @InitializationHint(initTime= InitializationTime.RUN,
                packageNames = { "io.netty.channel.epoll", "io.netty.internal.tcnative" },
                types = {
                        DefaultChannelId.class,
                        Socket.class,
                        Errors.class,
                        Limits.class, IovArray.class,
                        Http2ServerUpgradeCodec.class,
                        CleartextHttp2ServerUpgradeHandler.class,
                        Http2ConnectionHandler.class,
                        HostsFileEntriesResolver.class,
                        BrotliDecoder.class,
                        OpenSslPrivateKeyMethod.class,
                        OpenSslAsyncPrivateKeyMethod.class,
                        ReferenceCountedOpenSslEngine.class
                }, typeNames = {
                "io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder"
        })
})
// Enable reflective access for PlatformDependent#useDirectBufferNoCleaner - otherwise there's a strange behaviour with
// direct memory buffers
@NativeHint(trigger = PlatformDependent.class, options = "-Dio.netty.tryReflectionSetAccessible=true")

public class NettyHints implements  NativeConfiguration {
}
