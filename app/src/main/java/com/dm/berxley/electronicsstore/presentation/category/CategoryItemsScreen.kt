package com.dm.berxley.electronicsstore.presentation.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.dm.berxley.electronicsstore.R
import com.dm.berxley.electronicsstore.domain.models.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItemsScreen(
    navController: NavController,
    viewModel: CategoriesViewModel
) {

    val categoryState = viewModel.categoriesState.collectAsState().value

    val productsList = listOf(
        Product(
            1,
            "Surface laptop 3",
            "The Surface Laptop 3 with an Intel Core i7 10th Gen processor, 16GB RAM, and a 512GB SSD is a powerful device. It comes with a 13.5-inch PixelSense touchscreen display with a resolution of 2256 x 1504 pixels. It features Intel Iris Plus Graphics, which provide decent performance for most everyday tasks and even some light gaming.\n" +
                    "\n" +
                    "Here are the key specifications:\n" +
                    "\n" +
                    "Processor: Intel Core i7 10th Gen\n" +
                    "RAM: 16GB\n" +
                    "Storage: 512GB SSD\n" +
                    "Display: 13.5-inch PixelSense touchscreen\n" +
                    "Resolution: 2256 x 1504 pixels\n" +
                    "Graphics: Intel Iris Plus Graphics\n" +
                    "Operating System: Windows 10 or Windows 11 (depending on the update)\n" +
                    "The Surface Laptop 3 is known for its sleek design, premium build quality, and comfortable keyboard. It’s a versatile machine suitable for a wide range of tasks, from productivity work to multimedia consumption.",
            999.50,
            "USD",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
            )
        ),
        Product(
            2,
            "745 G6 i5 16/512 Ryzen 7",
            "The 745 G6 i5 Ryzen 7 is a business-class laptop designed for professionals who demand performance, security, and manageability in a sleek and portable package. Featuring a powerful combination of Intel and AMD processors, ample memory, and fast storage, this laptop is built to handle multitasking, productivity, and business applications with ease.\n" +
                    "\n" +
                    "Key Features\n" +
                    "\n" +
                    "Powerful Processors:\n" +
                    "\n" +
                    "Intel Core i5 Processor: This variant of the EliteBook 745 G6 comes with a reliable Intel Core i5 processor, which provides strong performance for everyday tasks, multitasking, and business applications.\n" +
                    "\n" +
                    "Ample Memory and Storage:\n" +
                    "16GB DDR4 RAM: With 16GB of RAM, this laptop offers smooth performance during multitasking and can handle demanding applications such as data analysis, content creation, and virtualization.\n" +
                    "\n" +
                    "512GB SSD Storage: The 512GB SSD ensures fast boot times, quick application loading, and ample storage space for documents, media, and software, with the added benefits of durability and power efficiency.",
            55000.0,
            "KES",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
            )
        ),
        Product(
            3,
            "Dragonfly i5 16/512",
            "The HP Elite Dragonfly is an ultra-light, premium business laptop, ideal for professionals who need a powerful, secure, and highly portable device.\n" +
                    "\n" +
                    "Processor: Intel Core i5 (8th or 10th Gen options)\n" +
                    "RAM: 16GB LPDDR3\n" +
                    "Storage: 512GB PCIe NVMe SSD\n" +
                    "Display:\n" +
                    "13.3-inch Full HD (1920 x 1080) touchscreen\n" +
                    "Optional 4K UHD display for higher resolution\n" +
                    "BrightView display with anti-reflection and anti-smudge coating\n" +
                    "Graphics: Integrated Intel UHD Graphics 620\n" +
                    "Weight: Starting at under 1 kg (2.2 lbs), making it one of the lightest business laptops\n" +
                    "Battery Life:\n" +
                    "Up to 24 hours, depending on configuration and usage\n" +
                    "Fast charging capability (50% charge in approximately 30 minutes)\n" +
                    "Connectivity:\n" +
                    "Wi-Fi 6 (802.11ax) for faster wireless speeds\n" +
                    "Bluetooth 5.0\n" +
                    "2x Thunderbolt 3 (USB-C)\n" +
                    "1x USB 3.1 Type-A\n" +
                    "HDMI 1.4\n" +
                    "3.5mm headphone/microphone combo jack\n" +
                    "Optional 4G LTE for mobile connectivity\n" +
                    "Security Features:\n" +
                    "HP Sure View Gen3 integrated privacy screen (optional)\n" +
                    "IR camera for facial recognition (Windows Hello)\n" +
                    "Fingerprint reader\n" +
                    "HP Sure Start Gen5 (self-healing BIOS)\n" +
                    "HP Sure Sense (AI-based malware protection)\n" +
                    "HP Privacy Camera (physical shutter for the webcam)\n" +
                    "Operating System: Windows 10 Pro, upgradable to Windows 11 Pro\n" +
                    "Build:\n" +
                    "Magnesium alloy chassis for a lightweight yet durable design\n" +
                    "Ocean-bound plastic components for eco-friendly construction\n" +
                    "Precision-crafted, with a quiet and spill-resistant keyboard\n" +
                    "Audio:\n" +
                    "Quad speakers tuned by Bang & Olufsen\n" +
                    "World-facing microphone for clearer voice capture during calls\n" +
                    "Special Features:\n" +
                    "Ultra-light design, highly portable for frequent travelers\n" +
                    "High-end audio and visual experience with optional 4K display and premium sound\n" +
                    "Eco-friendly with sustainable materials used in its construction\n" +
                    "This configuration of the HP Elite Dragonfly is particularly suited for business professionals who require a lightweight laptop without compromising on performance or security. Its long battery life, robust security features, and sleek design make it an excellent choice for those constantly on the move.",
            65000.0,
            "KES",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",

                )
        ),
        Product(
            4,
            "Hp 1030 G3 x360 8th corei5 16GB 256ssd Touch",
            "The HP EliteBook x360 1030 G3 is a high-end business laptop known for its versatility and premium build quality. Here’s an overview of its specifications based on the model with an 8th generation Intel Core i5, 16GB RAM, and 256GB SSD:\n" +
                    "\n" +
                    "HP EliteBook x360 1030 G3 Specifications\n" +
                    "General\n" +
                    "Model: HP EliteBook x360 1030 G3\n" +
                    "Operating System: Windows 10 Pro (upgradable to Windows 11)\n" +
                    "Form Factor: Convertible 2-in-1\n" +
                    "Processor\n" +
                    "CPU: Intel Core i5-8250U\n" +
                    "Generation: 8th Gen\n" +
                    "Base Clock Speed: 1.6 GHz\n" +
                    "Max Turbo Boost Speed: Up to 3.4 GHz\n" +
                    "Cores: 4\n" +
                    "Threads: 8\n" +
                    "Cache: 6MB SmartCache\n" +
                    "Memory\n" +
                    "RAM: 16GB\n" +
                    "Type: LPDDR3\n" +
                    "Speed: 2133 MHz\n" +
                    "Storage\n" +
                    "SSD: 256GB PCIe NVMe SSD\n" +
                    "Display\n" +
                    "Size: 13.3 inches\n" +
                    "Type: IPS LCD\n" +
                    "Resolution: Full HD (1920 x 1080 pixels)\n" +
                    "Touchscreen: Yes\n" +
                    "Brightness: 400 nits\n" +
                    "Corning Gorilla Glass: Yes\n" +
                    "Graphics\n" +
                    "Integrated GPU: Intel UHD Graphics 620\n" +
                    "Audio\n" +
                    "Speakers: Bang & Olufsen-tuned stereo speakers\n" +
                    "Microphones: Dual array digital microphones\n" +
                    "Connectivity\n" +
                    "Wi-Fi: Intel Dual Band Wireless-AC 8265 802.11a/b/g/n/ac (2×2)\n" +
                    "Bluetooth: Bluetooth 4.2\n" +
                    "Ports:\n" +
                    "2 x USB 3.1 Gen 1 Type-C with Thunderbolt support\n" +
                    "2 x USB 3.1 Gen 1 Type-A (1 charging)\n" +
                    "1 x HDMI 1.4\n" +
                    "1 x Headphone/Microphone Combo Jack\n" +
                    "1 x MicroSD card reader\n" +
                    "Input Devices\n" +
                    "Keyboard: Spill-resistant, backlit keyboard\n" +
                    "Touchpad: Multi-touch gesture-enabled\n" +
                    "Pen: Supports HP Active Pen with App Launch\n" +
                    "Security\n" +
                    "Fingerprint Reader: Yes\n" +
                    "IR Camera for Windows Hello: Yes\n" +
                    "HP Sure View Privacy Screen: Optional\n" +
                    "Other Security Features: TPM 2.0, HP BIOSphere Gen4, HP Sure Start Gen4\n" +
                    "Battery\n" +
                    "Type: 4-cell, 56.2 Wh Li-ion polymer\n" +
                    "Battery Life: Up to 18 hours (varies based on usage)\n" +
                    "Dimensions and Weight\n" +
                    "Dimensions: 12.04 x 8.07 x 0.61 inches (306 x 205 x 15.4 mm)\n" +
                    "Weight: Starting at 2.76 lbs (1.25 kg)\n" +
                    "Additional Features\n" +
                    "Camera: 720p HD webcam\n" +
                    "Durability: MIL-STD-810G tested\n" +
                    "Convertible Modes: Laptop, Stand, Tent, Tablet\n" +
                    "This HP EliteBook x360 1030 G3 offers robust performance, excellent build quality, and flexibility with its 2-in-1 design, making it suitable for professionals on the go.",
            50000.0,
            "KES",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",

                )
        ),
        Product(
            5,
            "Surface laptop 3",
            "The Surface Laptop 3 with an Intel Core i7 10th Gen processor, 16GB RAM, and a 512GB SSD is a powerful device. It comes with a 13.5-inch PixelSense touchscreen display with a resolution of 2256 x 1504 pixels. It features Intel Iris Plus Graphics, which provide decent performance for most everyday tasks and even some light gaming.\n" +
                    "\n" +
                    "Here are the key specifications:\n" +
                    "\n" +
                    "Processor: Intel Core i7 10th Gen\n" +
                    "RAM: 16GB\n" +
                    "Storage: 512GB SSD\n" +
                    "Display: 13.5-inch PixelSense touchscreen\n" +
                    "Resolution: 2256 x 1504 pixels\n" +
                    "Graphics: Intel Iris Plus Graphics\n" +
                    "Operating System: Windows 10 or Windows 11 (depending on the update)\n" +
                    "The Surface Laptop 3 is known for its sleek design, premium build quality, and comfortable keyboard. It’s a versatile machine suitable for a wide range of tasks, from productivity work to multimedia consumption.",
            999.50,
            "USD",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2023/12/Surface-Laptop-3-I7-10th-Gen-16-512-Touch-Laptop.png",
            )
        ),
        Product(
            6,
            "745 G6 i5 16/512 Ryzen 7",
            "The 745 G6 i5 Ryzen 7 is a business-class laptop designed for professionals who demand performance, security, and manageability in a sleek and portable package. Featuring a powerful combination of Intel and AMD processors, ample memory, and fast storage, this laptop is built to handle multitasking, productivity, and business applications with ease.\n" +
                    "\n" +
                    "Key Features\n" +
                    "\n" +
                    "Powerful Processors:\n" +
                    "\n" +
                    "Intel Core i5 Processor: This variant of the EliteBook 745 G6 comes with a reliable Intel Core i5 processor, which provides strong performance for everyday tasks, multitasking, and business applications.\n" +
                    "\n" +
                    "Ample Memory and Storage:\n" +
                    "16GB DDR4 RAM: With 16GB of RAM, this laptop offers smooth performance during multitasking and can handle demanding applications such as data analysis, content creation, and virtualization.\n" +
                    "\n" +
                    "512GB SSD Storage: The 512GB SSD ensures fast boot times, quick application loading, and ample storage space for documents, media, and software, with the added benefits of durability and power efficiency.",
            55000.0,
            "KES",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/745-G6-i5-16512-Ryzen-7.png",
            )
        ),
        Product(
            7,
            "Dragonfly i5 16/512",
            "The HP Elite Dragonfly is an ultra-light, premium business laptop, ideal for professionals who need a powerful, secure, and highly portable device.\n" +
                    "\n" +
                    "Processor: Intel Core i5 (8th or 10th Gen options)\n" +
                    "RAM: 16GB LPDDR3\n" +
                    "Storage: 512GB PCIe NVMe SSD\n" +
                    "Display:\n" +
                    "13.3-inch Full HD (1920 x 1080) touchscreen\n" +
                    "Optional 4K UHD display for higher resolution\n" +
                    "BrightView display with anti-reflection and anti-smudge coating\n" +
                    "Graphics: Integrated Intel UHD Graphics 620\n" +
                    "Weight: Starting at under 1 kg (2.2 lbs), making it one of the lightest business laptops\n" +
                    "Battery Life:\n" +
                    "Up to 24 hours, depending on configuration and usage\n" +
                    "Fast charging capability (50% charge in approximately 30 minutes)\n" +
                    "Connectivity:\n" +
                    "Wi-Fi 6 (802.11ax) for faster wireless speeds\n" +
                    "Bluetooth 5.0\n" +
                    "2x Thunderbolt 3 (USB-C)\n" +
                    "1x USB 3.1 Type-A\n" +
                    "HDMI 1.4\n" +
                    "3.5mm headphone/microphone combo jack\n" +
                    "Optional 4G LTE for mobile connectivity\n" +
                    "Security Features:\n" +
                    "HP Sure View Gen3 integrated privacy screen (optional)\n" +
                    "IR camera for facial recognition (Windows Hello)\n" +
                    "Fingerprint reader\n" +
                    "HP Sure Start Gen5 (self-healing BIOS)\n" +
                    "HP Sure Sense (AI-based malware protection)\n" +
                    "HP Privacy Camera (physical shutter for the webcam)\n" +
                    "Operating System: Windows 10 Pro, upgradable to Windows 11 Pro\n" +
                    "Build:\n" +
                    "Magnesium alloy chassis for a lightweight yet durable design\n" +
                    "Ocean-bound plastic components for eco-friendly construction\n" +
                    "Precision-crafted, with a quiet and spill-resistant keyboard\n" +
                    "Audio:\n" +
                    "Quad speakers tuned by Bang & Olufsen\n" +
                    "World-facing microphone for clearer voice capture during calls\n" +
                    "Special Features:\n" +
                    "Ultra-light design, highly portable for frequent travelers\n" +
                    "High-end audio and visual experience with optional 4K display and premium sound\n" +
                    "Eco-friendly with sustainable materials used in its construction\n" +
                    "This configuration of the HP Elite Dragonfly is particularly suited for business professionals who require a lightweight laptop without compromising on performance or security. Its long battery life, robust security features, and sleek design make it an excellent choice for those constantly on the move.",
            65000.0,
            "KES",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/08/Dragonfly-i5-16512.png",

                )
        ),
        Product(
            8,
            "Hp 1030 G3 x360 8th corei5 16GB 256ssd Touch",
            "The HP EliteBook x360 1030 G3 is a high-end business laptop known for its versatility and premium build quality. Here’s an overview of its specifications based on the model with an 8th generation Intel Core i5, 16GB RAM, and 256GB SSD:\n" +
                    "\n" +
                    "HP EliteBook x360 1030 G3 Specifications\n" +
                    "General\n" +
                    "Model: HP EliteBook x360 1030 G3\n" +
                    "Operating System: Windows 10 Pro (upgradable to Windows 11)\n" +
                    "Form Factor: Convertible 2-in-1\n" +
                    "Processor\n" +
                    "CPU: Intel Core i5-8250U\n" +
                    "Generation: 8th Gen\n" +
                    "Base Clock Speed: 1.6 GHz\n" +
                    "Max Turbo Boost Speed: Up to 3.4 GHz\n" +
                    "Cores: 4\n" +
                    "Threads: 8\n" +
                    "Cache: 6MB SmartCache\n" +
                    "Memory\n" +
                    "RAM: 16GB\n" +
                    "Type: LPDDR3\n" +
                    "Speed: 2133 MHz\n" +
                    "Storage\n" +
                    "SSD: 256GB PCIe NVMe SSD\n" +
                    "Display\n" +
                    "Size: 13.3 inches\n" +
                    "Type: IPS LCD\n" +
                    "Resolution: Full HD (1920 x 1080 pixels)\n" +
                    "Touchscreen: Yes\n" +
                    "Brightness: 400 nits\n" +
                    "Corning Gorilla Glass: Yes\n" +
                    "Graphics\n" +
                    "Integrated GPU: Intel UHD Graphics 620\n" +
                    "Audio\n" +
                    "Speakers: Bang & Olufsen-tuned stereo speakers\n" +
                    "Microphones: Dual array digital microphones\n" +
                    "Connectivity\n" +
                    "Wi-Fi: Intel Dual Band Wireless-AC 8265 802.11a/b/g/n/ac (2×2)\n" +
                    "Bluetooth: Bluetooth 4.2\n" +
                    "Ports:\n" +
                    "2 x USB 3.1 Gen 1 Type-C with Thunderbolt support\n" +
                    "2 x USB 3.1 Gen 1 Type-A (1 charging)\n" +
                    "1 x HDMI 1.4\n" +
                    "1 x Headphone/Microphone Combo Jack\n" +
                    "1 x MicroSD card reader\n" +
                    "Input Devices\n" +
                    "Keyboard: Spill-resistant, backlit keyboard\n" +
                    "Touchpad: Multi-touch gesture-enabled\n" +
                    "Pen: Supports HP Active Pen with App Launch\n" +
                    "Security\n" +
                    "Fingerprint Reader: Yes\n" +
                    "IR Camera for Windows Hello: Yes\n" +
                    "HP Sure View Privacy Screen: Optional\n" +
                    "Other Security Features: TPM 2.0, HP BIOSphere Gen4, HP Sure Start Gen4\n" +
                    "Battery\n" +
                    "Type: 4-cell, 56.2 Wh Li-ion polymer\n" +
                    "Battery Life: Up to 18 hours (varies based on usage)\n" +
                    "Dimensions and Weight\n" +
                    "Dimensions: 12.04 x 8.07 x 0.61 inches (306 x 205 x 15.4 mm)\n" +
                    "Weight: Starting at 2.76 lbs (1.25 kg)\n" +
                    "Additional Features\n" +
                    "Camera: 720p HD webcam\n" +
                    "Durability: MIL-STD-810G tested\n" +
                    "Convertible Modes: Laptop, Stand, Tent, Tablet\n" +
                    "This HP EliteBook x360 1030 G3 offers robust performance, excellent build quality, and flexibility with its 2-in-1 design, making it suitable for professionals on the go.",
            50000.0,
            "KES",
            "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
            listOf(
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",
                "https://hewlettcomputersolution.co.ke/wp-content/uploads/2024/07/Hp-1030-G3-x360-8th-corei5-16GB-256ssd-Touch-2.png",

                )
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    categoryState.selectedCategory?.name?.let {
                        Text(
                            text = it,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Navigate Back"
                        )
                    }
                })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 5.dp,
                    bottom = it.calculateBottomPadding() + 5.dp,
                    start = 12.dp,
                    end = 12.dp
                )
        ) {

            //filter here

            //gridlayout or two items with products here 
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(productsList) { product ->
                    ProductComp(product) {
                        //navigate tp product details page
                    }
                }
            }
        }

    }

}


@Composable
fun ProductComp(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .size(300.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),

        ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = rememberAsyncImagePainter(
                    model = product.imageUrl,
                    placeholder = painterResource(id = R.drawable.placeholder)
                ),
                contentDescription = product.name
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                Text(text = product.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "${product.currency} ${product.price}")
            }


        }
    }

}