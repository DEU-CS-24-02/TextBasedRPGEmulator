package net.biryeongtrain.text_emulator.item.component;

import com.mojang.serialization.Codec;
import net.biryeongtrain.text_emulator.registry.Registries;
import net.biryeongtrain.text_emulator.utils.Util;
import org.jetbrains.annotations.Nullable;


public interface DataComponent<T> {

    static <T> Builder<T> getBuilder() {
        return new Builder<>();
    }

    class Builder<T> {
        @Nullable
        private Codec<T> codec;

        public Builder() {}

        public Builder<T> codec(@Nullable Codec<T> codec) {
            this.codec = codec;
            return this;
        }

        public DataComponent<T> build() {
            return new SimpleDataComponent<>(this.codec);
        }
    }

    class SimpleDataComponent<T> implements DataComponent<T> {
        @Nullable
        private final Codec<T> codec;

        SimpleDataComponent(@Nullable Codec<T> codec) {
            this.codec = codec;
        }

        public @Nullable Codec<T> getCodec() {
            return this.codec;
        }

        public String toString() {
            return Util.registryValueToString(Registries.ITEM_COMPONENTS, this);
        }
    }
}
