from sortedcontainers import SortedDict

class Allocator:
    def __init__(self, n: int):
        self.avail = SortedDict({0: n})
        self.alloc = defaultdict(list)

    def allocate(self, size: int, mID: int) -> int:
        for start, free_size in self.avail.items():
            if free_size >= size:
                self.alloc[mID].append((start, size))
                del self.avail[start]
                # if there is still remaining memory, alloc that memory 
                if free_size > size:
                    self.avail[start+size] = free_size - size
                return start
        return -1

    def _combine_mem(self, s1, s2):
        # if the first node reach the second node, combine them. If not, there is occupied memory in between. It can't exceed s2
        if s1 + self.avail[s1] == s2:
            self.avail[s1] += self.avail[s2]
            del self.avail[s2]

    def freeMemory(self, mID: int) -> int:
        if mID not in self.alloc:
            return 0
        
        out = 0
        for start, size in self.alloc[mID]:
            self.avail[start] = size
            out += size

            # combine memory with the prev and next node
            # note that, first handle the next node, so that we don't need to move i
            i = self.avail.bisect_left(start)
            keys = self.avail.keys()
            if i < len(self.avail) - 1:
                self._combine_mem(start, keys[i+1])
            if i >= 0:
                self._combine_mem(keys[i-1], start)
        del self.alloc[mID]
        return out
        


# Your Allocator object will be instantiated and called as such:
# obj = Allocator(n)
# param_1 = obj.allocate(size,mID)
# param_2 = obj.freeMemory(mID)
