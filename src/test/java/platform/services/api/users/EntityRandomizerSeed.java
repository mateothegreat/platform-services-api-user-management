package platform.services.api.users;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicLong;

@Log4j2
public class EntityRandomizerSeed {

    protected static AtomicLong lastSeed = new AtomicLong(8682522807148012L ^ System.nanoTime());

    public static Long getLong() {

        return getNewSeed().longValue();

    }

    protected static AtomicLong getNewSeed() {

        final AtomicLong seed = new AtomicLong(generateNewSeed());

        lastSeed = seed;

        return seed;

    }

    protected static long generateNewSeed() {

        final AtomicLong seed = new AtomicLong(lastSeed.longValue() ^ System.nanoTime());

        while(true) {

            final long current = seed.get();
            final long next    = current * 181783497276652981L;

            if(seed.compareAndSet(current, next)) {

                return next;

            }

        }

    }

}
